package com.lifeAleksandra;

public class FoundProduct{

    protected String foundProductName;
    protected float foundProductPrice;
    protected float foundDeliveryPrice;
    protected float foundProductTotalPrice;
    protected float foundReputation;
    protected int shopId;

    public FoundProduct(String foundProductName, float foundProductPrice, float foundDeliveryPrice, float foundReputation, int shopId) {
        this.foundProductName = foundProductName;
        this.foundProductPrice = foundProductPrice;
        this.foundDeliveryPrice = foundDeliveryPrice;
        this.foundReputation = foundReputation;
        foundProductTotalPrice = foundProductPrice + foundDeliveryPrice;
        this.shopId = shopId;
    }

    public String getFoundProductName() {
        return foundProductName;
    }

    public float getFoundProductPrice() {
        return foundProductPrice;
    }

    public float getFoundDeliveryPrice() {
        return foundDeliveryPrice;
    }

    public float getFoundReputation() {
        return foundReputation;
    }

    public int getShopId() {
        return shopId;
    }

    public float getFoundProductTotalPrice() {
        return foundProductTotalPrice;
    }

    public FoundProduct isItBetter(FoundProduct firstProduct, FoundProduct secondProduct){

        if(firstProduct.getFoundProductTotalPrice() > secondProduct.getFoundProductTotalPrice()){
            return firstProduct;
        }
        else if(firstProduct.getFoundProductTotalPrice() < secondProduct.getFoundProductTotalPrice()){
            return secondProduct;
        }
        else{
            if(firstProduct.getFoundReputation() >= secondProduct.getFoundReputation()){
                return firstProduct;
            }
            else{
                return secondProduct;
            }
        }
    }

}
