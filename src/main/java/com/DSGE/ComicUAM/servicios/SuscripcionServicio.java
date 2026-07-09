package com.dsge.comicuam.servicios;

import com.dsge.comicuam.modelos.Usuario;
import com.dsge.comicuam.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario activarSuscripcion(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        usuario.setEsSuscriptor(true);
        return usuarioRepository.save(usuario);
    }

    public Usuario cancelarSuscripcion(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        usuario.setEsSuscriptor(false);
        return usuarioRepository.save(usuario);
    }
}