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

    public int getAmount() {
        return amount;
    }

    public float getMin_price() {
        return min_price;
    }

    public float getMax_price() {
        return max_price;
    }

    public float getReputation() {
        return reputation;
    }

    public Product(String name, int amount, float min_price, float max_price, float reputation) {
        this.name = name.replace(" ", "+");
        this.amount = amount;
        this.min_price = min_price;
        this.max_price = max_price;
        this.reputation = reputation;
    }
}