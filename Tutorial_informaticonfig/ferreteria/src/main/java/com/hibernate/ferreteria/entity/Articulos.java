package com.hibernate.ferreteria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="articulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulos {

    @Id // Declara la PK de la BBDD
    // @GeneratedValue → JPA/Hibernate genera el valor automáticamente.
    //GenerationType.IDENTITY → la base de datos genera el ID, normalmente mediante AUTO_INCREMENT.
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @Column(name = "id")
    private Long id;    // Pk, puede llevar otro nombre

    @Column(name="nombrearticulo")
    private String nombrearticulo;

    @Column(name="precio")
    private Double precio;

    @Column(name="existencia")
    private Integer existencia;

    /*
    // Metodo para visualizar correctamente los datos por consola
    @Override
    public String toString() {
        return "Articulos{" +
                "id=" + id +
                ", nombrearticulo='" + nombrearticulo + '\'' +
                ", precio=" + precio +
                ", existencia=" + existencia +
                '}';
    }

     */

}


