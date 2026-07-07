package com.dsge.comicuam.controladores;

import com.dsge.comicuam.modelos.Usuario;
import com.dsge.comicuam.servicios.SuscripcionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/suscripcion")
public class SuscripcionControlador {

    @Autowired
    private SuscripcionServicio suscripcionServicio;

    // Endpoint para suscribirse: POST http://localhost:8080/api/suscripcion/activar
    /*@PostMapping("/activar")
    public String activar(@RequestBody Usuario usuario) {
        suscripcionServicio.activarSuscripcion(usuario);
        return "Suscripción activada exitosamente";
    }*/

    @PostMapping("/activar")
    public ResponseEntity<Map<String, Object>> activar(@RequestBody Usuario usuario){
        suscripcionServicio.activarSuscripcion(usuario);

        //creamos una respuesta estructurada en formato JSON/Mapa
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "suscripción activada exitosamente");
        respuesta.put("status", "ok");
        respuesta.put("usuario", usuario.getId());

        return ResponseEntity.ok(respuesta); // Retorna un HTPP 200 OK en el JSON
    }
    
    // Endpoint para cancelar: POST http://localhost:8080/api/suscripcion/cancelar
    /*@PostMapping("/cancelar")
    public String cancelar(@RequestBody Usuario usuario) {
        suscripcionServicio.cancelarSuscripcion(usuario);
        return "Suscripción cancelada exitosamente";
    }*/

    @PostMapping("/cancelar")
    public ResponseEntity<Map<String, Object>> cancelar(@RequestBody Usuario usuario){
        suscripcionServicio.cancelarSuscripcion(usuario);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "suscripción cancelada exitosamente");
        respuesta.put("status", 200);

        return ResponseEntity.ok(respuesta);
    }

    //Usar postman para probar y cambiar el regreso del mensaje con protocolo
}