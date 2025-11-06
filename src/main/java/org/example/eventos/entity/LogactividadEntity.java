package org.example.eventos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "logsactividad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogactividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con usuario
    //@ManyToOne
    //@JoinColumn(name = "usuario_id", nullable = false)
    //private UsuarioEntity usuario;

    private String accion;
    private String entidad;
    private Long entidadId;
    private String detalles;
    private String direccion;
    private String userAgent;

    private LocalDateTime createdAt = LocalDateTime.now();
}
