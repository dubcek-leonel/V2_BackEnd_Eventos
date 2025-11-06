package org.example.eventos.dto;

import lombok.Data;

import java.time.LocalDateTime;

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

    // Constructor vacío
    public EventoDTO() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getEsPago() {
        return esPago;
    }
    public void setEsPago(Boolean esPago) {
        this.esPago = esPago;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Long getCreadoPor() {
        return creadoPor;
    }
    public void setCreadoPor(Long creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Long getActualizadoPor() {
        return actualizadoPor;
    }
    public void setActualizadoPor(Long actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

