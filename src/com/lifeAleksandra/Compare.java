package com.lifeAleksandra;

import java.util.ArrayList;

public class Compare{

    protected int numberOfSets = 5;
    protected int counter = 0;

    public FoundProduct[][] check(FoundProduct[][] defaultSet, int numberOfProducts, ArrayList<Integer> shopIDs, float priceSet1, float priceSet2, float priceSet3) {

        FoundProduct[][] beforeCheck = defaultSet;         // FoundProduct[wariacja cenowa produktu][dany produkt]

        FoundProduct[][] tmp = null;

        ArrayList<Integer> duplicateShopIDs = new ArrayList<Integer>();

        for(int i = 0; i < shopIDs.size()-1 ; i++) {
            for(int j = i+1; j < shopIDs.size(); j++){
                if(shopIDs.get(i).equals(shopIDs.get(j)) && !duplicateShopIDs.contains(shopIDs.get(i))){
                    duplicateShopIDs.add(shopIDs.get(i));   // lista sklepów, które mają różne produkty i są one w zestawieniach
                }
            }
        }

        // stworzenie tych zesatawień z tańszą dosatwą i porównanie z domyślnie najtańszymi zestawami XD

        // zastanowić się nad braniem odpowiednich produktów z zestawień do porównań shopID
        for(int IDs : duplicateShopIDs){    // dla każdego zduplikowanego shopid szukamy powiązanych produktówz danym jednym sklepie
            float maxDeliveryPrice = 0;
            float totalPricePromisingSet = 0;
            boolean foundIDinproducts = false;

            for(int i=0; i < numberOfProducts; i++) {
                for (int j=0; j < numberOfSets; j++) {
                    if(defaultSet[j][i] != null) {
                        if (defaultSet[j][i].shopId == IDs) {
                            if (defaultSet[j][i].foundDeliveryPrice > maxDeliveryPrice) {
                                maxDeliveryPrice = defaultSet[j][i].foundDeliveryPrice;
                                defaultSet[j][i].foundDeliveryPrice = 0;
                                tmp[counter][i] = defaultSet[j][i];
                                totalPricePromisingSet += tmp[counter][i].foundProductTotalPrice;
                                foundIDinproducts = true;
                                break;
                            }
                        }if( (j+1) == numberOfSets && foundIDinproducts == false){
                            tmp[counter][i] = defaultSet[j][i];   // jeżeli nie ma danego produktu w powiązannych sklepach to bierzemy najtańszy dany produkt :P
                            totalPricePromisingSet += tmp[counter][i].foundProductTotalPrice;
                        }
                        if ((i + 1) == numberOfSets && (j + 1) == numberOfProducts) { // znalezione wszystkie powiązane produkty z danym sklepem to zliczamy cenę za zestaw
                            totalPricePromisingSet += maxDeliveryPrice;
                            //Set s = new Set(tmp, totalPricePromisingSet);
                        }
                    }
                }
            }
            counter += 1;
        }

        /*for(int i=0; i < counter; i++){
            if (tmp[counter][i]){

            }
        }
        */
        return tmp;
    }
}
