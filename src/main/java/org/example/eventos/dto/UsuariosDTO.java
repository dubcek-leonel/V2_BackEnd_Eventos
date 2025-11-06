package org.example.eventos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDTO {
    private Long id;
    private String email;
    private int codigoEstudiante;
    private String nombre;
    private String apellidos;
    private String rol;
    private boolean activo;

    private Date createdAt;
    private Date updatedAt;

}
