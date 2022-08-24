package com.marketexample.mimarket.domain.repository;

// En este interfaz ponemos los metodos que cualquier repositorio que tenga productos tenga que implementar
// los metodos aqui son muy parecidos (casi siempre iguales - nach Bedarf) a los que estan en Entity en la clase
// ProductoRepository mas adelante, se implementa esta interfaz a la clase ProductoRepository en Entity

import com.marketexample.mimarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarceProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
