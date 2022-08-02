package com.marketexample.mimarket.persistence.crud;

import com.marketexample.mimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

// La interfaz crud repository pide que se le de la clase de la entity que se va a modificar, y el tipo de dato
// de la variable de la primary key. Este interfaz lo que hace es importar medotos de crud para la tabla seleccionada
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
