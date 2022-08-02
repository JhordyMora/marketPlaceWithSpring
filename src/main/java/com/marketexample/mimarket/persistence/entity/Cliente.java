package com.marketexample.mimarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
