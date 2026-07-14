package com.dsge.comicuam.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogginControlador {

    @GetMapping("/login")
    public String login() {
        return "forward:/login.html";
    }

    @GetMapping("/registro")
    public String registro() {
        // Cambiar aquí para que busque el nuevo archivo físico
        return "forward:/registro.html"; 
    }
}