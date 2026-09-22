package com.hibernate.ferreteria.mapper;


import com.hibernate.ferreteria.DTOs.ArticulosDTO;
import com.hibernate.ferreteria.entity.Articulos;

// Mapper: clase encargada de transformar objetos Entidad y DTO,
// evitando mezclar esta lógica en el controlador o servicio.
public class ArticulosMapper {

    public static ArticulosDTO toDTO (Articulos articulo) {
        return new ArticulosDTO(
                articulo.getId(),
                articulo.getNombrearticulo(),
                articulo.getPrecio(),
                articulo.getExistencia()
        );
    }

    public static Articulos toEntity(ArticulosDTO dto) {
        Articulos articulo = new Articulos();

        articulo.setNombrearticulo(dto.getNombrearticulo());
        articulo.setPrecio(dto.getPrecio());
        articulo.setExistencia(dto.getExistencia());

        return articulo;
    }
}
