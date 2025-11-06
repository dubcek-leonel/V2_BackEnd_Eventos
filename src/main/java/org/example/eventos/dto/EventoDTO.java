package org.example.eventos.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String categoria;
    private String ubicacion;
    private Integer capacidad;
    private Boolean esPago;
    private Double precio;
    private String imagenUrl;
    private Boolean estado;

    private Long creadoPor;
    private Long actualizadoPor;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

