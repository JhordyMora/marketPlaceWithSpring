package com.marketexample.mimarket.persistence;

import com.marketexample.mimarket.persistence.crud.ProductoCrudRepository;
import com.marketexample.mimarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
