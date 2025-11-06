package org.example.eventos.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Double monto;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @Column(name = "numero_operacion", length = 100)
    private String numeroOperacion;

    @Column(name = "comprobante_url")
    private String comprobanteUrl;

    @Column(length = 50)
    private String estado;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(columnDefinition = "TEXT")
    private String notas;

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

    // Muchos pagos pertenecen a una inscripción
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "inscripcion_id", nullable = false)
    //private Inscripcion inscripcion;

    // Muchos pagos pueden ser verificados por un usuario
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "verificado_por")
    //private Usuario verificadoPor;
}