package com.lifeAleksandra;

public class Product {

    protected String name;
    protected int amount;
    protected float min_price;
    protected float max_price;
    protected float reputation;

    public Product(String name, int amount, float min_price, float max_price, float reputation) {
        this.name = name.replace(" ", "+");
        this.amount = amount;
        this.min_price = min_price;
        this.max_price = max_price;
        this.reputation = reputation;
    }
}