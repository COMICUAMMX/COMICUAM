package com.dsge.comicuam.servicios;

import com.dsge.comicuam.modelos.Suscripcion;
import com.dsge.comicuam.modelos.Usuario;
import com.dsge.comicuam.repositorios.SuscripcionRepository;
import com.dsge.comicuam.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SuscripcionServicio {

    private static final int DIAS_PLAN_BASICO = 30;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public Usuario activarSuscripcion(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + idUsuario));

        LocalDate hoy = LocalDate.now();
        LocalDate vencimiento = hoy.plusDays(DIAS_PLAN_BASICO);

        Suscripcion suscripcion = new Suscripcion(idUsuario, "Básico", hoy, vencimiento);
        suscripcionRepository.save(suscripcion);

        // Ajustes para la nueva BD:
        usuario.setEsSuscriptor(true);
        usuario.setFechaVencimientoSuscripcion(vencimiento); // Sincroniza con el nuevo campo del usuario
        return usuarioRepository.save(usuario);
    }

    public Usuario cancelarSuscripcion(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + idUsuario));

        suscripcionRepository.findByIdUsuarioAndEstado(idUsuario, Suscripcion.ESTADO_ACTIVA)
                .ifPresent(suscripcion -> {
                    suscripcion.cancelarPlan();
                    suscripcionRepository.save(suscripcion);
                });

        // Ajustes para la nueva BD:
        usuario.setEsSuscriptor(false);
        usuario.setFechaVencimientoSuscripcion(null); // Limpia la fecha al dar de baja
        return usuarioRepository.save(usuario);
    }
}
