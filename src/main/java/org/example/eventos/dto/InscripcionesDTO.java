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
public class InscripcionesDTO {
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
}
