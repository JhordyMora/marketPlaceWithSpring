package com.marketexample.mimarket.persistence.entity;

import javax.persistence.*;

@Entity
// Entitiy significa la representacion de las tablas dentro de una clase en java
// Buena practica es definiar las clases en singular (Al menos la ultima palabra)
@Table(name="productos")
//Como la tabla tiene un nonmbre diferente se referencia la tabla con este tag

public class Producto {
    @Id
    //esto se pone pq idProducto es la llave primaria en la tabla, esta una clave sencilla hay otras que son compuestas
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Esto se usa para generar un valor para el id de manera automatica para la llave primaria.
    // Necesita siempre del parametro strategy. Esto no se utiliza si por ejemplo la llave primaria es un
    // valor que es externo a nosotros y el cliente o usario nos lo dan por ejemplo en un cliente seria la cedula.
    // Si ese valor es la llave primaria no se necesita este tag.
    @Column(name="id_producto")
    // como el nombre de la columna es diferente con el tag se hace referencia a este
    private Integer idProducto;


    //como el nombre de la columna y de la variable aqui son iguales, no se pone el tag Column
    private String nombre;

    @Column(name="id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name ="precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    // Se crea esta variable para generar las conexiones entre las tablas
    // Se usan tag para representar esas conexiones, definiendo que tipo es (many to one or to many)
    @ManyToOne
    // esto significa que muchas categorias estan en un producto.
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    // cuales son las celdas que se conectan con join column con name. Los otros dos argumentos se usan
    // para decir si se puede actualizar o insertar un dato desde la clase (tabla) producto, en este caso no vamos a
    // permitir nada de eso.  Asi que este join column nos sirve traer la informacion de la categoria a la que pertenece
    // un producto.
    private Categoria categoria;

    // LIST -> se podria crear una lista de compras dentro de la clase producto pero el profe dijo que no era necesario
    // Mirar la clase Compra (la entity compra)

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
