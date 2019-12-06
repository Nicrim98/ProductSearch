package com.lifeAleksandra;

public class Product {

    protected String name;
    protected int amount;
    protected float min_price;
    protected float max_price;
    protected float reputation;

    public String getName() {
        return name;
    }

    public Product(String name, int amount, float min_price, float max_price) {
        this.name = name.replace(" ", "+");
        this.amount = amount;
        this.min_price = min_price;
        this.max_price = max_price;
        this.reputation = 4;
    }
}