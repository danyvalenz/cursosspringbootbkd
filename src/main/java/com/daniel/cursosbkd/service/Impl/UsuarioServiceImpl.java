package com.daniel.cursosbkd.service.Impl;

import com.daniel.cursosbkd.entities.Usuario;
import com.daniel.cursosbkd.repository.UsuariosRepository;
import com.daniel.cursosbkd.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuariosRepository usuariosRepository;

    public UsuarioServiceImpl(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public List<Usuario> findAllUsers() {
        return usuariosRepository.findAll();
    }
}
