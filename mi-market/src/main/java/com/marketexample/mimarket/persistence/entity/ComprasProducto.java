package com.marketexample.mimarket.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compras_productos")

public class ComprasProducto {
    // Cuándo hay más de una llave primaria en la tabla no se puede meter las dos en la clase. Lo que se hace es
    // crear otra clase donde contenga las dos llaves primarias y luego crear una variable con la clase y usar el
    // tag @EmbeddedId

    @EmbeddedId
    // EmbeddedID se usa cuando se tiene varias llaves primarias, si fuera una sola se usa Id. Mirar como explique el
    // proceso para crear una clase aparte para las llaves primarias y traerlas aquí
    private ComprasProductoPK id;
    //como el nombre de la columna y de la variable aquí son iguales, no se pone el tag Column
    private Integer cantidad;

    private Double total;

    private Boolean estado;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
