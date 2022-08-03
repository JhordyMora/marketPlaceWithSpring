package com.marketexample.mimarket.persistence.entity;

//aqui no se pone @Identity pq esto no es una tabla en la base de datos, es solo para manejar las 2 llaves primarias
// y mandarla a la clase que si es una table

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
// esto se usa para decir que esta clase es una parte de otra, o que va ser usada en otra

public class ComprasProductoPK implements Serializable {

    // se implementa la interfaz serealisable para poder la informacion en binario y mas rapido (creo)

    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
