package org.example.eventos.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MetodoPagoEventoDTO {
    private Long id;
    private String nombreMetodo;
    private String descripcion;
    private Boolean activo;

    private LocalDateTime createdAt;
    private Long eventoId;
}
