package com.marketexample.mimarket.persistence;

import com.marketexample.mimarket.domain.Product;
import com.marketexample.mimarket.domain.repository.ProductRepository;
import com.marketexample.mimarket.persistence.crud.ProductoCrudRepository;
import com.marketexample.mimarket.persistence.entity.Producto;
import com.marketexample.mimarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// @Repository: le indicamos a la clase que es la encarga de interactuar con la base de datos.
// en algun momento se le tiene que implementar la interfaz que se creo en repository que es la conecta
// este con la copia de la clase que se va a mostrar afuera
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper productMapper;

    // Antes aqui era List<Producto> pq se hizo automatico pero a lo largo del curso nos dimos cuenta que necesitamos
    // mapear las cosas para mostrarlas externamente y se cambio a List<Producto> (sin o la final). Por lo tanto se
    // modifico el elemento para que sea correcto, importanto el metodo en mapper
    @Override
    public List<Product> getAll(){
        // forma anterior
        //  return (List<Producto>) productoCrudRepository.findAll();
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    // este tambien se modifico parecido al de arriba
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        // Esta linea de arriba genera una optional de lista de productos. En este caso dentro de ProductMapper no tengo
        // una funcion que cambie a una lista de opcionales, asi que usamos lambda dentro de la funcion map. La
        // funcion map retorna un optional.
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<Producto> producto =  productoCrudRepository.findById(productId);
        // similar a lo situacion de arriba pero en este caso con en ves de ser una lista, en con un solo producto, que
        // no esta dentro de un optional
        return  producto.map(prod -> productMapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
