package org.example.eventos.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventos")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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