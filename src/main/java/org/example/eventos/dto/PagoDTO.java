package org.example.eventos.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private long id;
    //private String inscripcionId;
    private Double monto;
    private String metodoPago;
    private String numeroOperacion;
    private String comprobanteUrl;
    private String estado;
    private LocalDateTime fechaPago;
    private String verificadoPorId;
    private String notas;

    private Date createdAt;
    private Date updatedAt;
}