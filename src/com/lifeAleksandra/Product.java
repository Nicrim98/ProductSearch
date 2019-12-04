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

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMin_price(float min_price) {
        this.min_price = min_price;
    }

    public void setMax_price(float max_price) {
        this.max_price = max_price;
    }

    public void setReputation(float reputation) {
        this.reputation = reputation;
    }

    public Product(String name, int amount, float min_price, float max_price) {
        this.name = name.replace(" ", "+");
        this.amount = amount;
        this.min_price = min_price;
        this.max_price = max_price;
    }
}