package com.marketexample.mimarket.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
// Entitiy significa la representacion de las tablas dentro de una clase en java
// Buena practica es definiar las clases en singular (Al menos la ultima palabra)

@Table(name = "compras")
//Como la tabla tiene un nonmbre diferente se referencia la tabla con este tag

public class Compra {
    @Id
    //esto se pone pq idProducto es la llave primaria en la tabla, esta una clave sencilla hay otras que son compuestas
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Esto se usa para generar un valor para el id de manera automatica para la llave primaria.
    // Necesita siempre del parametro strategy. Esto no se utiliza si por ejemplo la llave primaria es un
    // valor que es externo a nosotros y el cliente o usario nos lo dan por ejemplo en un cliente seria la cedula.
    // Si ese valor es la llave primaria no se necesita este tag.
    @Column(name = "id_compra")
    // como el nombre de la columna es diferente con el tag se hace referencia a este
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    //como el nombre de la columna y de la variable aquí son iguales, no se pone el tag Column
    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
