package com.dsge.comicuam.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogginControlador {

    @GetMapping("/loggin")
    public String loggin() {
        System.out.println("Loggin");
        return "loggin";
    }
    
}
