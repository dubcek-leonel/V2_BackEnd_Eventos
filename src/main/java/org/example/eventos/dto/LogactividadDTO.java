package org.example.eventos.dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class LogactividadDTO {

    private Long id;
    //private Long usuarioId; // ManyToOne
    private String accion;
    private String entidad;
    private Long entidadId;
    private String detalles;
    private String direccion;
    private String userAgent;
    private LocalDateTime createdAt;
}
