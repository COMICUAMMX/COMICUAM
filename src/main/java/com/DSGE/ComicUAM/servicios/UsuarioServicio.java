package com.dsge.comicuam.servicios;

import com.dsge.comicuam.modelos.Usuario;
import com.dsge.comicuam.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario nuevoUsuario) {
        // 1. Validar si el email ya existe
        if (usuarioRepository.findByEmail(nuevoUsuario.getEmail()).isPresent()) {
            throw new RuntimeException("El correo electrónico ya está registrado.");
        }

        // 2. Por defecto, empieza sin suscripción activa
        nuevoUsuario.setEsSuscriptor(false);

        // NOTA: Para producción, encripta 'nuevoUsuario.getPassword()' usando BCrypt.
        // Por ahora lo guardaremos en texto plano para validar que tu flujo funcione.

        // 3. Guardar en MySQL
        return usuarioRepository.save(nuevoUsuario);
    }
}
