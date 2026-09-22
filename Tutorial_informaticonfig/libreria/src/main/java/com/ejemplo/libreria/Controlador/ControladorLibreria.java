package com.ejemplo.libreria.Controlador;


import com.ejemplo.libreria.Model.Libros;
import com.ejemplo.libreria.RepoLibros.RepoLibros;
import com.ejemplo.libreria.Servicio.I_ServicioLibro;
import com.ejemplo.libreria.Servicio.ServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {

    // Dependencia del Service
    private final I_ServicioLibro i_servicio;

    // Constructor: Spring inyecta automáticamente el Service
    public ControladorLibreria(I_ServicioLibro i_servicio) {
        this.i_servicio = i_servicio;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Libros> obtenerPorId(@PathVariable long id) {
        Optional<Libros> libro = i_servicio.obtenerPorId(id);
        return libro.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libros>crear(@RequestBody Libros libro) {
        i_servicio.guardar(libro);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id){
        i_servicio.eliminaPorId(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/todos")
    public List<Libros> listar() {
        return i_servicio.ObtenerTodos();
    }


}
