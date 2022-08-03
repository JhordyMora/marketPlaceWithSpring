package com.marketexample.mimarket.persistence.crud;

import com.marketexample.mimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// La interfaz crud repository pide que se le de la clase de la entity que se va a modificar, y el tipo de dato
// de la variable de la primary key. Este interfaz lo que hace es importar y definir metodos de crud para la tabla seleccionada
// ademas de definir otros metodos mas que se desean tener para aplicarlos en las tablas (clases) del producto.
// En este caso la clase ProductoRepository
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // aqui estamos usando QueryMethods que nos ayudan a llamar informacion sin ayuda de SQL. Cuando estos se usan se
    // debe respetar siempre el camelcase. Por lo tanto asi haya una variable que empieze con minuscula, se le debe
    // poner mayuscula si es el caso. En el parentesis no se respeta el camelcase si no como se llama en la clase
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    //Opcional, se puede usar, en este caso el tag @Query(value="SELECT * FROM productos WHERE id_categoria = ?", nativeQuery=True)
    // y luego crear la lista y poner cualquier nombre de metodo, aunque ahi no estariamos usando QueryMethods sino tags

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
