package com.project.educom.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "topics")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    // Relación ManyToOne con Thread
    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Hilo hilo;

}
