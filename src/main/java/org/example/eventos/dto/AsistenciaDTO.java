package org.example.eventos.dto;

import lombok.*;
import org.example.eventos.entity.UsuariosEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AsistenciaDTO {

    private Long id;

    // Relaciona con la inscripción
    private Long inscripcionId;

    // Usuario que registró la asistencia
   // private Long registradoPorId;

   private LocalDateTime fechaHoraRegistro;
    private String metodoRegistro;
    private String notas;
  //  private LocalDateTime createdAt;



    private UsuariosEntity usuario;

}