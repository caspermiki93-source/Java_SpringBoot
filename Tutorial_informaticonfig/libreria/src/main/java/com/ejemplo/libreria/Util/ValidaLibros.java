package com.ejemplo.libreria.Util;


import com.ejemplo.libreria.Model.Libros;
import org.springframework.stereotype.Component;

@Component
public class ValidaLibros {

    public Libros libro;

    public boolean TituloValido (){
        return libro.getTitulo() !=  null && !libro.getTitulo().isBlank();
    }
}
