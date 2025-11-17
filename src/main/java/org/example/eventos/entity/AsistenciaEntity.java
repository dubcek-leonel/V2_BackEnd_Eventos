package org.example.eventos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "asistencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Inscripción (1 inscripción -> muchas asistencias)
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "inscripcion_id", nullable = false)
    //private InscripcionEntity inscripcion;

    // Relación con Usuario (quien registró la asistencia)
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "registrado_por", nullable = false)
    //private UsuarioEntity registradoPor;

    @Column(name = "fecha_hora_registro", nullable = false)
    private LocalDateTime fechaHoraRegistro;

    @Column(name = "metodo_registro", length = 50)
    private String metodoRegistro;


    @Column(columnDefinition = "TEXT")
    private String notas;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")//, nullable = false)
    @JsonBackReference
    private UsuariosEntity usuario;






    @PrePersist
    public void prePersist() {
        this.fechaHoraRegistro = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }
}
