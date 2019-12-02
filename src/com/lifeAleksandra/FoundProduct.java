package com.lifeAleksandra;

public class FoundProduct{

    protected String foundProductName;
    protected float foundProductPrice;
    protected float foundDeliveryPrice;
    protected float foundProductTotalPrice;
    protected float foundReputation;
    protected String url;
    protected int shopId;

    public FoundProduct(String foundProductName, float foundProductPrice, float foundDeliveryPrice, float foundReputation, String url) {
        this.foundProductName = foundProductName;
        this.foundProductPrice = foundProductPrice;
        this.foundDeliveryPrice = foundDeliveryPrice;
        this.foundReputation = foundReputation;
        foundProductTotalPrice = foundProductPrice + foundDeliveryPrice;
        this.url = url;
        String[] id =url.split("/");
        shopId = Integer.parseInt(id[5]);

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


    public float getFoundProductTotalPrice() {
        return foundProductTotalPrice;
    }
    public String getUrl() {
        return url;
    }

    public boolean isItBetter(FoundProduct firstProduct, FoundProduct secondProduct){

        if(firstProduct.getFoundProductTotalPrice() < secondProduct.getFoundProductTotalPrice()){
            return true;
        }
        else if(firstProduct.getFoundProductTotalPrice() > secondProduct.getFoundProductTotalPrice()){
            return false;
        }
        else{
            if(firstProduct.getFoundReputation() >= secondProduct.getFoundReputation()){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public int returnShopId(){
        String[] id = getUrl().split("/");
        int shopId = Integer.parseInt(id[4]);
        return shopId;
    }

}
