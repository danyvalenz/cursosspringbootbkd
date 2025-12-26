package com.daniel.cursosbkd.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Usuario (ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Relación con Curso (ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Column(name = "fecha_inscripcion", nullable = false)
    private Date fechaInscripcion = new Date();

    @Column(name = "progreso_porcentaje", nullable = false)
    private Integer progresoPorcentaje = 0; // Para el dashboard (0 a 100)

    @Column(name = "ultima_vista")
    private Date ultimaVista;
}
