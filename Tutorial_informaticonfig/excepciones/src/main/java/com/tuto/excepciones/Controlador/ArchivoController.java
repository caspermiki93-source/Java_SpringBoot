package com.tuto.excepciones.Controlador;

import com.tuto.excepciones.Servicio.FileContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculadora")
public class ArchivoController {

    private final FileContent contenido;

    public ArchivoController(FileContent contenido) {
        this.contenido = contenido;
    }

    @GetMapping("/lectura")
    public ResponseEntity<String> lectura(@RequestParam String ruta) {

        String elArchivo = contenido.Lecturaarchivo(ruta);

        return ResponseEntity.ok(elArchivo);
    }
}
