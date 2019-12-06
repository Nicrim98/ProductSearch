package com.lifeAleksandra;

import java.util.ArrayList;

public class Compare{

    protected int numberOfSets = 5;
    protected int counter = 0;

    public FoundProduct[][] check(FoundProduct[][] defaultSet, int numberOfProducts, ArrayList<Integer> shopIDs, float priceSet1, float priceSet2, float priceSet3) {

        FoundProduct[][] finalSet = defaultSet;

        ArrayList<Integer> duplicateShopIDs = new ArrayList<Integer>();

        for(int i = 0; i < shopIDs.size()-1 ; i++) {
            for(int j = i+1; j < shopIDs.size(); j++){
                if(shopIDs.get(i).equals(shopIDs.get(j)) && !duplicateShopIDs.contains(shopIDs.get(i))){
                    duplicateShopIDs.add(shopIDs.get(i));   // lista sklepów, które mają różne produkty i są one w zestawieniach
                }
            }
        }

        // stworzenie tych zesatawień z tańszą dosatwą i porównanie z domyślnie najtańszymi zestawami XD
        //FoundProduct[][] tmp = new FoundProduct[duplicateShopIDs.size()][numberOfProducts];
        FoundProduct[][] tmp = new FoundProduct[1000][duplicateShopIDs.size()];
        Set[] set_tmp = new Set[duplicateShopIDs.size()];
        // zastanowić się nad braniem odpowiednich produktów z zestawień do porównań shopID

        for (int IDs : duplicateShopIDs) {    // dla każdego zduplikowanego shopid szukamy powiązanych produktówz danym jednym sklepie
            float maxDeliveryPrice = 0;
            float totalPricePromisingSet = 0;
            boolean foundIDInProducts = false;

            for (int i = 0; i < numberOfProducts; i++) {
                foundIDInProducts = false;
                for (int j = 0; j < numberOfSets; j++) {    //domyślnie 5 opcji tych produktów do porównania

                    if (defaultSet[i][j] != null) {
                       // System.out.println(defaultSet[i][j].shopId == IDs);

                        if (defaultSet[i][j].shopId == IDs && !foundIDInProducts) {
                            if (defaultSet[i][j].getFoundDeliveryPrice() > maxDeliveryPrice) {
                                maxDeliveryPrice = defaultSet[i][j].getFoundDeliveryPrice();
                                defaultSet[i][j].setFoundDeliveryPrice(0);
                            }
                            tmp[i][counter] = defaultSet[i][j];
                            totalPricePromisingSet = totalPricePromisingSet + (tmp[i][counter].getFoundProductPrice());
                            foundIDInProducts = true;
                        }

                    }
                    if ((j + 1) == numberOfSets && !foundIDInProducts && defaultSet[i][0] != null) {    // musi byc poza def[][] != null, ponieważ jesli nie znajdzie produktu z id, a ostatni bedzie null np. to nie wejdzie nam do tego if'a
                        tmp[i][counter] = defaultSet[i][0];   // jeżeli nie ma danego produktu w powiązannych sklepach to bierzemy najtańszy dany produkt
                        totalPricePromisingSet = totalPricePromisingSet + tmp[i][counter].getFoundProductTotalPrice();
                    }


                    if ((i + 1) == numberOfProducts && (j + 1) == numberOfSets) { // znalezione wszystkie powiązane produkty z danym sklepem to zliczamy cenę za zestaw
                        int idCounter = 0;

                        for(int k=0; k<numberOfProducts;k++){
                            if(tmp[k][counter] != null) {
                                if (tmp[k][counter].getShopId() == IDs) {
                                    idCounter++;
                                }
                            }
                        }

                        if(idCounter > 1) {
                            totalPricePromisingSet = totalPricePromisingSet + maxDeliveryPrice;
                            set_tmp[counter] = new Set(tmp[counter], totalPricePromisingSet);
                            counter = counter + 1;
                        }
                    }
                }
            }

        }

        System.out.println("marcin");

        for(int i=0; i < duplicateShopIDs.size(); i++){
                if (set_tmp[i] != null) {

                    boolean change = false;
                    System.out.println(" Cena do porownan..." + set_tmp[i].priceForSet);

                    if (set_tmp[i].priceForSet < priceSet1) {
                        for(int j=0; j < numberOfProducts; j++) {
                            finalSet[j][2] = finalSet[i][1];
                            finalSet[j][1] = finalSet[i][0];
                            finalSet[j][0] = tmp[j][i];
                        }
                        priceSet3 = priceSet2;
                        priceSet2 = priceSet1;
                        priceSet1 = set_tmp[i].priceForSet; // update ceny pierwszeego zestawu
                        change = true;
                    }

                    if (set_tmp[i].priceForSet < priceSet2 && !change && set_tmp[i].priceForSet != priceSet1) {
                        for(int j=0; j < numberOfProducts; j++) {
                            finalSet[j][2] =finalSet[j][1];
                            finalSet[j][1] = tmp[j][i];
                        }
                        priceSet3 = priceSet2;
                        priceSet2 = set_tmp[i].priceForSet; // update ceny drugiego zestawu
                        change = true;
                    }

                    if (set_tmp[i].priceForSet < priceSet3 && !change && set_tmp[i].priceForSet != priceSet1 && set_tmp[i].priceForSet != priceSet2) {

                        for(int j=0; j < numberOfProducts; j++) {
                            finalSet[j][2] = tmp[j][i];
                        }
                        priceSet3 = set_tmp[i].priceForSet; // pdate ceny rzeciego zestawu
                    }

                }
        }

        return finalSet;
    }
}
