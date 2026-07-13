package com.dsge.comicuam.controladores;

import com.dsge.comicuam.modelos.Usuario;
import com.dsge.comicuam.servicios.UsuarioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Endpoints para registro y login de cuentas")
public class AutenticacionControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/registrar")
    @Operation(summary = "Registrar una nueva cuenta de usuario")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioCreado = usuarioServicio.registrarUsuario(usuario);
            return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
