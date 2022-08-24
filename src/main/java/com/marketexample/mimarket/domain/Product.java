package com.marketexample.mimarket.domain;

// lo que hacen estas clases en domain es volver a hacer una copia de las entities, pero esta es la capa que
// va a estar conectada hacia el exterior. Su objetivo es proteger la estructura interior de la base de datos
// En domain se hace la copia o la tabla que se quiere presentar externamente y luego con ayuda de un mapper
// se traera la informacion necesaria

public class Product {
    // Aqui en el dominio no se debe usar Integer, se usa int
    // estamos tomando las mismas variables de las clases de entity, y creando una copia de las variables que nos interesen
    // pero con nombre en ingles. En este caso no traimos codigo de barras pq no nos interesa que la gente exterior lo
    // vea
    private int productId;
    private String name;
    // Aqui en el dominio no se debe usar Integer, se usa int
    private int categoryId;
    // Aqui en el dominio no se debe usar Double, se usa double
    private double price;
    // Aqui en el dominio no se debe usar Integer, se usa int
    private int stock;
    // Aqui en el dominio no se debe usar Boolean, se usa boolean
    private boolean active;
    private Category category;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean active() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
