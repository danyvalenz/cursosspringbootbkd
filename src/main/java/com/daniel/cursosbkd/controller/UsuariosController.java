package com.daniel.cursosbkd.controller;

import com.daniel.cursosbkd.entities.Usuario;
import com.daniel.cursosbkd.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class UsuariosController {
    private final UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("hola")
    public String hola(){
        return "HOla";
    }

    @GetMapping("usuarios")
    public List<Usuario> findAllUsers(){
        return usuarioService.findAllUsers();
    }

}
