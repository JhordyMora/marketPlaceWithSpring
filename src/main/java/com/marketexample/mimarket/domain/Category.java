package com.marketexample.mimarket.domain;

// lo que hacen estas clases en domain es volver a hacer una copia de las entities, pero esta es la capa que
// va a estar conectada hacia el exterior. Su objetivo es proteger la estructura interior de la base de datos
// En domain se hace la copia o la tabla que se quiere presentar externamente y luego con ayuda de un mapper
// se traera la informacion necesaria

public class Category {

    // Aqui en el dominio no se debe usar Integer, se usa int
    private int categoryId;
    private String category;
    private boolean active;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
