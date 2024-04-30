package com.project.educom.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "mensaje", columnDefinition = "TEXT")
    private String mensaje;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "hilo_id", referencedColumnName = "id")
    private Hilo hilo;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name = "link")
    private String link;

    // Constructor sin argumentos
    public Comentario() {
    }

    // Constructor con todos los argumentos
    public Comentario(String mensaje, Usuario usuario, Hilo hilo, LocalDateTime fechaCreacion, String link) {
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.hilo = hilo;
        this.fechaCreacion = fechaCreacion;
        this.link = link;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Hilo getHilo() {
        return hilo;
    }

    public void setHilo(Hilo hilo) {
        this.hilo = hilo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
