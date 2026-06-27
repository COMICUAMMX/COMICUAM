package com.dsge.comicuam.controladores;

import com.dsge.comicuam.modelos.Usuario;
import com.dsge.comicuam.servicios.SuscripcionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suscripcion")
public class SuscripcionControlador {

    @Autowired
    private SuscripcionServicio suscripcionServicio;

    // Endpoint para suscribirse: POST http://localhost:8080/api/suscripcion/activar
    @PostMapping("/activar")
    public String activar(@RequestBody Usuario usuario) {
        suscripcionServicio.activarSuscripcion(usuario);
        return "Suscripción activada exitosamente";
    }

    // Endpoint para cancelar: POST http://localhost:8080/api/suscripcion/cancelar
    @PostMapping("/cancelar")
    public String cancelar(@RequestBody Usuario usuario) {
        suscripcionServicio.cancelarSuscripcion(usuario);
        return "Suscripción cancelada exitosamente";
    }
}