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
                        System.out.println(defaultSet[i][j].shopId == IDs);

                        if (defaultSet[i][j].shopId == IDs && !foundIDInProducts) {
                            if (defaultSet[i][j].getFoundDeliveryPrice() > maxDeliveryPrice) {
                                maxDeliveryPrice = defaultSet[i][j].getFoundDeliveryPrice();
                                defaultSet[i][j].setFoundDeliveryPrice(0);
                            }
                            System.out.println("Znaleziony produkt " + defaultSet[i][j].getFoundProductName());
                            tmp[i][counter] = defaultSet[i][j];
                            totalPricePromisingSet = totalPricePromisingSet + (tmp[i][counter].getFoundProductPrice());
                            foundIDInProducts = true;
                        }

                    }
                    if ((j + 1) == numberOfSets && !foundIDInProducts && defaultSet[i][0] != null) {    // musi byc poza def[][] != null, ponieważ jesli nie znajdzie produktu z id, a ostatni bedzie null np. to nie wejdzie nam do tego if'a
                        tmp[i][counter] = defaultSet[i][0];   // jeżeli nie ma danego produktu w powiązannych sklepach to bierzemy najtańszy dany produkt :P
                        totalPricePromisingSet = totalPricePromisingSet + tmp[i][counter].getFoundProductTotalPrice();
                    }


                    if ((i + 1) == numberOfProducts && (j + 1) == numberOfSets) { // znalezione wszystkie powiązane produkty z danym sklepem to zliczamy cenę za zestaw
                        // trzeba by sprawdzić czy dane shopID występuje w jakimś innym produkcie
                        int idCounter = 0;

                        for(int k=0; k<numberOfProducts;k++){
                            if(tmp[k][counter] != null) {
                                if (tmp[k][counter].getShopId() == IDs) {
                                    idCounter++;
                                }
                            }
                        }

                        if(idCounter > 1) {
                            System.out.println(" Zakończyłem zestaw potencjalnie lepszy, o to i on...");
                            totalPricePromisingSet = totalPricePromisingSet + maxDeliveryPrice;
                            System.out.println(" Cena promising set = " + totalPricePromisingSet);
                            System.out.println(duplicateShopIDs.size() + " O to mój size");
                            System.out.println(" HEJKA... " + counter);
                            set_tmp[counter] = new Set(tmp[counter], totalPricePromisingSet);
                            counter = counter + 1;
                        }
                    }
                }
            }

        }

        System.out.println("marcin");
       // Sort.bublle(set_tmp, counter); // pytanie czy to działa XD // NIE DZIALA :P

        for(int i=0; i < duplicateShopIDs.size(); i++){
                if (set_tmp[i] != null) {

                    boolean change = false;
                    System.out.println(" Cena do porownan..." + set_tmp[i].priceForSet);

                    if (set_tmp[i].priceForSet < priceSet1) {
                        for(int j=0; j < numberOfProducts; j++) {
                            System.out.println(" siema");
                            System.out.println(" porownuje z... " + priceSet1);
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
                        System.out.println(set_tmp[i].priceForSet + "WHY ?!");
                        System.out.println(" XDDDD");
                        System.out.println(" porownuje z... " + priceSet2);
                        for(int j=0; j < numberOfProducts; j++) {
                            finalSet[j][2] =finalSet[j][1];
                            System.out.println(finalSet[j][2].getFoundProductPrice() + "jej");
                            System.out.println(tmp[j][1].getFoundProductPrice() + "ejej");
                            finalSet[j][1] = tmp[j][i]; // It finally works :P
                        }
                        priceSet3 = priceSet2;
                        priceSet2 = set_tmp[i].priceForSet; // update ceny drugiego zestawu
                        change = true;
                    }

                    if (set_tmp[i].priceForSet < priceSet3 && !change && set_tmp[i].priceForSet != priceSet1 && set_tmp[i].priceForSet != priceSet2) {
                        System.out.println("YOLO");
                        System.out.println(" porownuje z... " + priceSet3);
                        for(int j=0; j < numberOfProducts; j++) {
                            finalSet[j][2] = tmp[j][i]; // nie nastepuje podmiana nie wiedziec czemu XD
                            System.out.println(finalSet[j][2].getFoundProductName() + "jej");
                            System.out.println(tmp[j][i].getFoundProductName() + "ejej");
                        }
                        priceSet3 = set_tmp[i].priceForSet; // pdate ceny rzeciego zestawu
                    }

                }
        }
        System.out.println(" Moje pricy..." + " " + priceSet1 + " " + priceSet2 + " " + priceSet3);

        return finalSet;
    }
}
