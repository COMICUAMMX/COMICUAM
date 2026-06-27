package com.dsge.comicuam.servicios;

import com.dsge.comicuam.modelos.Usuario;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionServicio {

    // Método para activar suscripción
    public void activarSuscripcion(Usuario usuario) {
        usuario.setEsSuscriptor(true);
        // Aquí se haría un repositorio.save(usuario) para guardarlo en BD
    }

    // Método para cancelar suscripción
    public void cancelarSuscripcion(Usuario usuario) {
        usuario.setEsSuscriptor(false);
        // Aquí se actualizaría en BD
    }
}