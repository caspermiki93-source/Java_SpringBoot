package com.tuto.excepciones.Servicio;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileContent {
    public String Lecturaarchivo(String ruta) {
        try {
            Path v_ruta = Paths.get(ruta);
            return Files.readString(v_ruta);

        } catch (IOException ERROR) {
            throw new RuntimeException("Error en lectura de archivo"
                    + ERROR.getMessage(), ERROR);
        }
    }
}
