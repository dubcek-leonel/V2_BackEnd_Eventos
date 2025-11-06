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
@Table(name = "usuarios")
public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private int codigoEstudiante;
    private String nombre;
    private String apellidos;
    private String rol;
    private boolean activo;

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
