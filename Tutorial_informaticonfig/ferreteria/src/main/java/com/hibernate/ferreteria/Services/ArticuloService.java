package com.hibernate.ferreteria.Services;

import com.hibernate.ferreteria.DTOs.ArticulosDTO;
import com.hibernate.ferreteria.Repositorios.Repo_Articulos;
import com.hibernate.ferreteria.entity.Articulos;
import com.hibernate.ferreteria.mapper.ArticulosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    CLASE PARA GESTIONAR LA LOGICA DE NEGOCIO
 */

@Service
public class ArticuloService {

    @Autowired
    private Repo_Articulos repo;

    public List<ArticulosDTO> serv_consulta () {
        return repo.findAll().stream().map(ArticulosMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ArticulosDTO serv_Insertar (ArticulosDTO dto){
        Articulos articulo = ArticulosMapper.toEntity(dto);
        Articulos insertado = repo.save(articulo);
        return ArticulosMapper.toDTO(insertado);
    }

    public ArticulosDTO serv_Actualiza (Long id, ArticulosDTO dto) {
        Optional<Articulos> existe = repo.findById(id);

        if (existe.isPresent()) {
            Articulos articulo = existe.get();

            articulo.setNombrearticulo(dto.getNombrearticulo());
            articulo.setPrecio(dto.getPrecio());
            articulo.setExistencia(dto.getExistencia());

            Articulos actualizado = repo.save(articulo);

            return ArticulosMapper.toDTO(actualizado);
        } else {
            throw new RuntimeException(("Articulo no encontrado con id:" + id));
        }
    }

    public String serv_Eliminar (Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Articulo eliminado correctamente";
        } else {
            return "Articulo: " + id + "No encontrado";
        }
    }


    public ArticulosDTO serv_BuscarPorId(Long id) {

        Optional<Articulos> existe = repo.findById(id);

        if (existe.isPresent()) {
            return ArticulosMapper.toDTO(existe.get());
        } else {
            throw new RuntimeException("Articulo no encontrado con id: " + id);
        }
    }
}
