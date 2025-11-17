package org.example.eventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "estudiantes_upeu")
@Getter
@Setter
@NoArgsConstructor
public class EstudianteUpeuEntity {

    @Id
    @Column(name = "codigo_estudiante", nullable = false, length = 50)
    private String codigoEstudiante;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(length = 100)
    private String facultad;

    @Column(name = "escuela_profesional", length = 100)
    private String escuelaProfesional;

    @Column(length = 20)
    private String semestre;

    @Column(length = 20)
    private String telefono;

    @Column(nullable = false)
    private Boolean estado = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
