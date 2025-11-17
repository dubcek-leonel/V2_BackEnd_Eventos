package org.example.eventos.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EstudianteUpeuDTO {
    private Long codigoEstudiante;
    private String nombre;
    private String apellidos;
    private String email;
    private String facultad;
    private String escuelaProfesional;
    private String semestre;
    private String telefono;
    private Boolean estado;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
