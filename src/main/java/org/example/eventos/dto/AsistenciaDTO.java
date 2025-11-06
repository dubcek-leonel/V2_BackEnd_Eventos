package org.example.eventos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AsistenciaDTO {

    private Long id;

    // Relaciona con la inscripción
    private Long inscripcionId;

    // Usuario que registró la asistencia
    private Long registradoPorId;

    private LocalDateTime fechaHoraRegistro;
    private String metodoRegistro;
    private String notas;
    private LocalDateTime createdAt;
}