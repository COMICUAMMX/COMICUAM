package com.dsge.comicuam.controladores;

import com.dsge.comicuam.modelos.Usuario;
import com.dsge.comicuam.servicios.UsuarioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map; // Para recibir los datos de login de forma limpia

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

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión en la plataforma")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String email = credenciales.get("email");
        String password = credenciales.get("password");

        // 1. Buscamos el usuario en la base de datos a través del servicio
        Usuario usuarioEncontrado = usuarioServicio.buscarPorEmail(email);

        // 2. ¡VALIDACIÓN CRUCIAL! Si no existe o la contraseña no coincide, se le rebota
        if (usuarioEncontrado == null || !usuarioEncontrado.getPassword().equals(password)) {
            return new ResponseEntity<>("Correo o contraseña incorrectos", HttpStatus.UNAUTHORIZED);
        }

        // 3. Si todo está correcto, lo dejamos pasar y retornamos sus datos (o el rol que necesites)
        return new ResponseEntity<>(usuarioEncontrado, HttpStatus.OK);
    }
}