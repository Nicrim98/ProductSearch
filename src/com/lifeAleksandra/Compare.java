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
        FoundProduct[][] tmp = new FoundProduct[duplicateShopIDs.size()][numberOfProducts];
        Set[] set_tmp = new Set[duplicateShopIDs.size()];
        // zastanowić się nad braniem odpowiednich produktów z zestawień do porównań shopID

        for(int IDs : duplicateShopIDs) {    // dla każdego zduplikowanego shopid szukamy powiązanych produktówz danym jednym sklepie
            float maxDeliveryPrice = 0;
            float totalPricePromisingSet = 0;
            boolean foundIDInProducts = false;

            for (int i = 0; i < numberOfProducts; i++) {
                for (int j = 0; j < numberOfSets; j++) {
                    if (defaultSet[j][i] != null) {
                        if (defaultSet[j][i].shopId == IDs) {
                            if (defaultSet[j][i].foundDeliveryPrice > maxDeliveryPrice) {
                                maxDeliveryPrice = defaultSet[j][i].foundDeliveryPrice;
                                defaultSet[j][i].foundDeliveryPrice = 0;
                                tmp[counter][i] = defaultSet[j][i];
                                totalPricePromisingSet += tmp[counter][i].foundProductTotalPrice;
                                foundIDInProducts = true;
                                break;
                            }
                        }
                        if ((j + 1) == numberOfSets && !foundIDInProducts) {
                            tmp[counter][i] = defaultSet[j][i];   // jeżeli nie ma danego produktu w powiązannych sklepach to bierzemy najtańszy dany produkt :P
                            totalPricePromisingSet += tmp[counter][i].foundProductTotalPrice;
                        }
                        if ((i + 1) == numberOfSets && (j + 1) == numberOfProducts) { // znalezione wszystkie powiązane produkty z danym sklepem to zliczamy cenę za zestaw
                            totalPricePromisingSet += maxDeliveryPrice;
                            set_tmp[counter] = new Set(tmp[counter], totalPricePromisingSet);
                        }
                    }
                }
            }
            counter += 1;
        }

        Sort.buble(set_tmp, counter);

        for(int i=0; i < counter; i++){
            if(counter < 3) {
                if (set_tmp[i] != null) {
                    boolean change = false;
                    if (set_tmp[i].priceForSet >= priceSet1) {
                        finalSet[0] = tmp[i];
                        change = true;
                    }
                    if (set_tmp[i].priceForSet >= priceSet2 && !change) {
                        finalSet[1] = tmp[i];
                        change = true;
                    }
                    if (set_tmp[i].priceForSet >= priceSet3 && !change) {
                        finalSet[2] = tmp[i];
                    }
                }
            }
        }

        return finalSet;
    }
}
