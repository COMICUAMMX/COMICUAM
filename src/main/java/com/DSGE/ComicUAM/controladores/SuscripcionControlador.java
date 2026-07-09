package com.dsge.comicuam.controladores;

import com.dsge.comicuam.modelos.Usuario;
import com.dsge.comicuam.servicios.SuscripcionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/suscripcion")
public class SuscripcionControlador {

    @Autowired
    private SuscripcionServicio suscripcionServicio;

    // POST http://localhost:8080/api/suscripcion/activar/1
    @PostMapping("/activar/{id}")
    public ResponseEntity<Map<String, Object>> activar(@PathVariable Long id) {
        Usuario usuario = suscripcionServicio.activarSuscripcion(id);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "suscripción activada exitosamente");
        respuesta.put("status", 200);
        respuesta.put("usuario", usuario.getId());

        return ResponseEntity.ok(respuesta);
    }

    // POST http://localhost:8080/api/suscripcion/cancelar/1
    @PostMapping("/cancelar/{id}")
    public ResponseEntity<Map<String, Object>> cancelar(@PathVariable Long id) {
        Usuario usuario = suscripcionServicio.cancelarSuscripcion(id);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "suscripción cancelada exitosamente");
        respuesta.put("status", 200);
        respuesta.put("usuario", usuario.getId());

        return ResponseEntity.ok(respuesta);
    }
}