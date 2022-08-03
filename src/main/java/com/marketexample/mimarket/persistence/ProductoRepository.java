package com.marketexample.mimarket.persistence;

import com.marketexample.mimarket.persistence.crud.ProductoCrudRepository;
import com.marketexample.mimarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// @Repository: le indicamos a la clase que es la encarga de interactuar con la base de datos.
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos (int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        // este metodo no se creo pq como la interfaz productoCrudRepository extiende de CrudRepository y esta
        // ya tiene estos metodos
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        // este metodo no se creo pq como la interfaz productoCrudRepository extiende de CrudRepository y esta
        // ya tiene estos metodos
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
