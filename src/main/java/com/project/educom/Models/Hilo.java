package com.project.educom.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "threads")
public class Hilo {

    //GPT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "mensaje", columnDefinition = "TEXT")
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "link")
    private String link;

    // Constructor sin argumentos
    public Hilo() {
    }

    // Constructor con todos los argumentos
    public Hilo(String titulo, String mensaje, Topico topico, Usuario usuario, LocalDateTime fechaCreacion, String link) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.topico = topico;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.link = link;
    }
    //FIN GPT
}
