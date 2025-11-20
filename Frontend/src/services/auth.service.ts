// src/app/services/auth.service.ts

import { Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, tap } from 'rxjs';

// --- Interfaces DTO (deben coincidir con las de Spring) ---

interface LoginRequest {
  usernameOrEmail: string; // O 'email' o 'username' según tu DTO
  password: string;
}

interface RegistroUsuarioRequest {
  nombre: string;
  username: string;
  email: string;
  password: string;
}

interface AuthResponse {
  accessToken: string;
  tokenType: string;
  // ... otros campos como nombre, roles, etc.
}

interface ApiResponse<T> {
  success: boolean;
  message: string;
  data: T;
}

// -------------------------------------------------------------

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly apiUrl = 'http://localhost:8080/auth'; // <--- Base de tu AuthController
  private readonly JWT_KEY = 'auth_token';

  isLoggedIn = signal(false);

  constructor(private router: Router, private http: HttpClient) {
    this.checkTokenOnLoad();
  }

  // --- Manejo del Token ---
  getToken(): string | null {
    return localStorage.getItem(this.JWT_KEY);
  }

  private setToken(token: string): void {
    localStorage.setItem(this.JWT_KEY, token);
    this.isLoggedIn.set(true);
  }

  private checkTokenOnLoad(): void {
    if (this.getToken()) {
      this.isLoggedIn.set(true);
    }
  }

  // Devuelve la cabecera Authorization para peticiones protegidas
  getAuthHeaders() {
    const token = this.getToken();
    if (token) {
      // Nota: Tu AuthController retorna 'accessToken', que es el JWT.
      return {
        headers: {
          'Authorization': `Bearer ${token}`
        }
      };
    }
    return {};
  }

  // --- Comunicación con AuthController ---

  /**
   * Llama al endpoint POST /auth/login
   */
  login(request: LoginRequest): Observable<ApiResponse<AuthResponse>> {
    return this.http.post<ApiResponse<AuthResponse>>(`${this.apiUrl}/login`, request).pipe(
      tap(response => {
        if (response.success && response.data?.accessToken) {
          // Guarda el JWT en el storage si el login es exitoso
          this.setToken(response.data.accessToken);
          this.router.navigate(['/eventos']); // Redirigir a la lista de eventos
        }
      })
    );
  }

  /**
   * Llama al endpoint POST /auth/registro
   */
  registro(request: RegistroUsuarioRequest): Observable<ApiResponse<AuthResponse>> {
    return this.http.post<ApiResponse<AuthResponse>>(`${this.apiUrl}/registro`, request).pipe(
      tap(response => {
        if (response.success && response.data?.accessToken) {
          // Guarda el JWT y loguea al usuario después del registro
          this.setToken(response.data.accessToken);
          this.router.navigate(['/eventos']);
        }
      })
    );
  }

  logout(): void {
    localStorage.removeItem(this.JWT_KEY);
    this.isLoggedIn.set(false);
    this.router.navigate(['/']);
  }
}
