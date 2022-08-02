package com.marketexample.mimarket.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
// Entitiy significa la representacion de las tablas dentro de una clase en java
// Buena practica es definiar las clases en singular (Al menos la ultima palabra)
@Table(name = "clientes")
//Como la tabla tiene un nonmbre diferente se referencia la tabla con este tag

public class Cliente {
    @Id
    //esto se pone pq idProducto es la llave primaria en la tabla, esta una clave sencilla hay otras que son compuestas
    //como el nombre de la columna y de la variable aqui son iguales, no se pone el tag Column
    // No se usa GenerateValue, mirar la definicion en la otra identities
    private String id;

    private String nombre;

    private String apellidos;

    private Integer celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    // mirar como se hizo la configuracion de compra. Cuando se usa este tag, se debe poner la variable con
    // la relacion opuesta (manytoone) a la que se encuentra en la otra clase. Se  relacionada con mappedby.
    // En este caso el nombre de la variable es cliente que esta en la clase compra
    @OneToMany(mappedBy = "cliente")
    // esto significa que un cliente puede tener muchas compras. En la variable de abajo se usa una lista. Mirarla
    private List<Compra> compras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
