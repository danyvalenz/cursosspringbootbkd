package com.daniel.cursosbkd.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;


    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro = new Date();

    @Column(nullable = false)
    private String rol = "ESTUDIANTE";
}
