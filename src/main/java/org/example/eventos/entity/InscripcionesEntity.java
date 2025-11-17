package org.example.eventos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inscripciones")//nombre tabla

public class InscripcionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //+eventoId
    //+usuarioId

    private String codigoEstudiante;
    private String nombreEstudiante;
    private String apellidosEstudiante;
    private String emailEstudiante;
    private String estado;
    private String metodoPago;
    private String comprobantePagoURL;
    private String esInscripcionMasiva;
    private Date fechaInscripcion;
    private Date fechaConfirmacion;
    //+confirmado

    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }


}
