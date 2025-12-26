package com.daniel.cursosbkd.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(columnDefinition = "TEXT") // Permite texto largo
    private String descripcion;

    @Column(nullable = false)
    private BigDecimal precio; // Usar BigDecimal para manejar dinero

    @Column(name = "url_portada")
    private String urlPortada; // URL de la imagen que se muestra en el dashboard

    @Column(name = "fecha_creacion")
    private Date fechaCreacion = new Date();

    // Relación: Un curso tiene muchas lecciones (OneToMany)
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Leccion> lecciones;
}
