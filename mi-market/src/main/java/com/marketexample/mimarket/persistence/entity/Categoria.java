package com.marketexample.mimarket.persistence.entity;

import javax.persistence.*;

@Entity
// Entitiy significa la representacion de las tablas dentro de una clase en java
// Buena practica es definiar las clases en singular (Al menos la ultima palabra)

@Table(name = "categorias")
//Como la tabla tiene un nonmbre diferente se referencia la tabla con este tag

public class Categoria {

    @Id
    //esto se pone pq idProducto es la llave primaria en la tabla, esta una clave sencilla hay otras que son compuestas
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Esto se usa para generar un valor para el id de manera automatica para la llave primaria.
    // Necesita siempre del parametro strategy. Esto no se utiliza si por ejemplo la llave primaria es un
    // valor que es externo a nosotros y el cliente o usario nos lo dan por ejemplo en un cliente seria la cedula.
    // Si ese valor es la llave primaria no se necesita este tag.
    @Column(name = "id_categoria")
    // como el nombre de la columna es diferente con el tag se hace referencia a este
    private Integer idCategoria;
    //como el nombre de la columna y de la variable aqui son iguales, no se pone el tag Column
    private String descripcion;

    private Boolean estado;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
