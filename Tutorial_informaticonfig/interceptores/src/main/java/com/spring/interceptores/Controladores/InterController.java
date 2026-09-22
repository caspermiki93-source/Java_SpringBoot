package com.spring.interceptores.Controladores;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterController {
    @GetMapping("/saludos")
    public String saludar () {
        return "Probando interceptores";
    }
}
