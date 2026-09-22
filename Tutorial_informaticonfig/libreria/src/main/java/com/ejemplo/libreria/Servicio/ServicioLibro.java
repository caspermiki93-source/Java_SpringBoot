package com.ejemplo.libreria.Servicio;

import com.ejemplo.libreria.Model.Libros;
import com.ejemplo.libreria.RepoLibros.I_RepoLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service        //Marcamos la clase como servicio, manejo de la logica de programacion
public class ServicioLibro implements I_ServicioLibro {

    // El Service necesita el Repository
    private final I_RepoLibros i_repo;

    // Spring inyecta automáticamente el Repository
    @Autowired
    public ServicioLibro(I_RepoLibros i_repo) {
        this.i_repo = i_repo;
    }


    @Override
    public List<Libros> ObtenerTodos() {
        return i_repo.findAll();
    }

    @Override
    public Optional<Libros> obtenerPorId(long id) {
        return i_repo.findById(id);
    }

    @Override
    public Libros guardar(Libros libro) {
        i_repo.save(libro);
        return libro;
    }

    @Override
    public void eliminaPorId(long id) {
        i_repo.deleteById(id);
    }

    @Override
    public String buscalibroPorTitulo(String titulo) {

        boolean encontrado = i_repo.findAll().stream()
                .anyMatch(libro -> libro.getTitulo() != null
                        && libro.getTitulo().equalsIgnoreCase(titulo));

        return encontrado ? "Libro encontrado" : "Libro no encontrado";

    }
}
