package com.daniel.cursosbkd.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lecciones")
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer orden; // Para saber el orden de las lecciones

    @Column(name = "vimeo_id", nullable = false, unique = true)
    private String vimeoId; // ¡CLAVE! ID del video en Vimeo (para incrustación segura)

    @Column(name = "duracion_segundos")
    private Integer duracionSegundos;

    // Relación: Muchas lecciones pertenecen a un curso (ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}
