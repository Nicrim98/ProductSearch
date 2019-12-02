package com.lifeAleksandra;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

public class ProductTest{   // klasa do przetestowania i pokazania działania jak układane są produkty z tego samego sklepu

    //public FoundProduct[][] check(FoundProduct[][] defaultSet, int numberOfProducts, ArrayList<Integer> shopIDs, float priceSet1, float priceSet2, float priceSet3) {
    public static void main (String[]args){

        ArrayList<Integer> a = new ArrayList<Integer>();

        FoundProduct f11 = new FoundProduct("Myszka1 Logitech", 100, 10, 4, 100);
        a.add(100);
        FoundProduct f12 = new FoundProduct("Myszka2 Logitech", 200, 10, 4, 101);
        a.add(101);
        FoundProduct f13 = new FoundProduct("Myszka3 Logitech", 210, 20, 4, 102);
        a.add(102);
        FoundProduct f14 = new FoundProduct("Myszka4 Logitech", 211, 15, 4, 201);
        a.add(201);
        FoundProduct f15 = new FoundProduct("Myszka5 Logitech", 300, 10, 4, 104);
        a.add(104);

        FoundProduct f21 = new FoundProduct("iphone1", 1000, 20, 4, 200);
        a.add(200);
        FoundProduct f22 = new FoundProduct("iphone2", 1100, 15, 4, 201);
        a.add(201);
        FoundProduct f23 = new FoundProduct("iphone3", 1200, 12, 4, 202);
        a.add(202);
        FoundProduct f24 = new FoundProduct("iphone4", 1300, 13, 4, 203);
        a.add(203);
        FoundProduct f25 = new FoundProduct("iphone5", 1400, 10, 4, 204);
        a.add(204);

        FoundProduct f31 = new FoundProduct("mac1", 1, 2, 4, 300);
        a.add(300);
        FoundProduct f32 = new FoundProduct("mac2", 3, 4, 4, 301);
        a.add(301);
        FoundProduct f33 = new FoundProduct("mac3", 5, 6, 4, 302);
        a.add(302);
        FoundProduct f34 = new FoundProduct("mac4", 7, 8, 4, 303);
        a.add(303);
        FoundProduct f35 = new FoundProduct("mac5", 9, 10, 4, 304);
        a.add(304);

        FoundProduct[][] def = new FoundProduct[5][3];
        def[0][0] = f11;
        def[1][0] = f12;
        def[2][0] = f13;
        def[3][0] = f14;
        def[4][0] = f15;

        def[0][1] = f21;
        def[1][1] = f22;
        def[2][1] = f23;
        def[3][1] = f24;
        def[4][1] = f25;

        def[0][2] = f31;
        def[1][2] = f32;
        def[2][2] = f33;
        def[3][2] = f34;
        def[4][2] = f35;

        FoundProduct[][] defs = new FoundProduct[3][5];
        defs[0][0] = f11;
        defs[0][1] = f12;
        defs[0][2] = f13;
        defs[0][3] = f14;
        defs[0][4] = f15;

        defs[1][0] = f21;
        defs[1][1] = f22;
        defs[1][2] = f23;
        defs[1][3] = f24;
        defs[1][4] = f25;

        defs[2][0] = f31;
        defs[2][1] = f32;
        defs[2][2] = f33;
        defs[2][3] = f34;
        defs[2][4] = f35;

        int priceSet1 = 1133;
        int priceSet2 = 1332;
        int priceSet3 = 1453;

        //check(FoundProduct[][] defaultSet, int numberOfProducts, ArrayList<Integer> shopIDs, float priceSet1, float priceSet2, float priceSet3) {
        FoundProduct[][] finalSet = new FoundProduct[3][3];

        Compare cos = new Compare();
        finalSet = cos.check(defs, 3, a, priceSet1, priceSet2, priceSet3);
        // wywołana funkcja czek i na dole jest jeszcze wypisanie, albo można sobie to zakompentować 'Compare' i lecieć po kolei wywołaniami pod spodem ;)
/* CHECK CHECK CHECK
        finalSet[0][0] = defs[0][0];
        finalSet[0][1] = defs[1][0];
        finalSet[0][2] = defs[2][0];

        finalSet[1][0] = defs[0][1];
        finalSet[1][1] = defs[1][1];
        finalSet[1][2] = defs[2][1];

        finalSet[2][0] = defs[0][2];
        finalSet[2][1] = defs[1][2];
        finalSet[2][2] = defs[2][2];
       // Compare porownaj = new Compare();
       // finalSet = porownaj.check(def,2,  a, 300, 302,304);

      /*  for(int i=0; i<3; i++){
            for(int j=0; j<2;j++){
                System.out.println(finalSet[i][j].getFoundProductName());
            }
        }
*/
      /*  ArrayList<Integer> duplicateShopIDs = new ArrayList<Integer>();

        for(int i = 0; i < a.size()-1 ; i++) {
            for(int j = i+1; j < a.size(); j++){
                if(a.get(i).equals(a.get(j)) && !duplicateShopIDs.contains(a.get(i))){
                    duplicateShopIDs.add(a.get(i));   // lista sklepów, które mają różne produkty i są one w zestawieniach
                }
            }
        }

        for(int i=0; i<duplicateShopIDs.size();i++){
            System.out.println(duplicateShopIDs.get(i));
        }

        int counter = 0;
        FoundProduct[][] tmp = new FoundProduct[duplicateShopIDs.size()][3];
        Set[] set_tmp = new Set[duplicateShopIDs.size()];
        // zastanowić się nad braniem odpowiednich produktów z zestawień do porównań shopID

        for(int IDs : duplicateShopIDs) {    // dla każdego zduplikowanego shopid szukamy powiązanych produktówz danym jednym sklepie
            float maxDeliveryPrice = 0;
            float totalPricePromisingSet = 0;
            boolean foundIDInProducts = false;
            //System.out.println(def[0][0].getFoundDeliveryPrice());
            for (int i = 0; i < 3; i++) {
                foundIDInProducts = false;
                for (int j = 0; j < 5; j++) {
                    if (def[j][i] != null) {
                        //System.out.println(def[j][i].getShopId());
                        //System.out.println(def[j][i].getShopId() == IDs);
                        if (def[j][i].getShopId() == IDs && !foundIDInProducts) {
                            System.out.println("Siema" + i);
                            System.out.println(def[j][i].getFoundProductPrice());
                            //System.out.println(def[0][0].getFoundProductPrice());
                            System.out.println(maxDeliveryPrice);
                            if (def[j][i].foundDeliveryPrice >= maxDeliveryPrice) {
                                maxDeliveryPrice = def[j][i].foundDeliveryPrice;
                                System.out.println(maxDeliveryPrice);
                                def[j][i].foundDeliveryPrice = 0;
                                System.out.println(def[j][i].foundDeliveryPrice);
                                tmp[counter][i] = def[j][i];
                                System.out.println(tmp[counter][i].foundProductName);
                                System.out.println(def[j][i].getFoundProductTotalPrice());
                                totalPricePromisingSet = totalPricePromisingSet + tmp[counter][i].foundProductPrice;
                                System.out.println(totalPricePromisingSet);
                                foundIDInProducts = true;
                            }
                        }
                        if ((j + 1) == 5 && !foundIDInProducts) {
                            System.out.println("Wchodze");
                            tmp[counter][i] = def[0][i];   // jeżeli nie ma danego produktu w powiązannych sklepach to bierzemy najtańszy dany produkt :P
                            System.out.println(tmp[counter][i].getFoundProductTotalPrice());
                            totalPricePromisingSet = totalPricePromisingSet + tmp[counter][i].getFoundProductTotalPrice();
                            System.out.println(totalPricePromisingSet);
                        }
                    }
                    if ((i + 1) == 3 && (j + 1) == 5) { // znalezione wszystkie powiązane produkty z danym sklepem to zliczamy cenę za zestaw
                        totalPricePromisingSet = totalPricePromisingSet + maxDeliveryPrice;
                        System.out.println("hejka");
                        set_tmp[counter] = new Set(tmp[counter], totalPricePromisingSet);
                    }
                }
            }
            counter = counter + 1;
            System.out.println(counter);
        }


        // sortowanie i porownanie XD
        Sort.buble(set_tmp, counter);

        System.out.println(counter);
        for(int i=0; i < counter; i++){
            if(counter < 3) {
                System.out.println(i);
                if (set_tmp[i] != null) {
                    boolean change = false;
                    System.out.println("Działam " + set_tmp[i].priceForSet);
                    if (set_tmp[i].priceForSet <= priceSet1) {
                        finalSet[0] = tmp[i];
                        change = true;
                    }
                    if (set_tmp[i].priceForSet <= priceSet2 && !change) {
                        finalSet[1] = tmp[i];
                        change = true;
                    }
                    if (set_tmp[i].priceForSet <= priceSet3 && !change) {
                        finalSet[2] = tmp[i];

                    }
                }
            }
        }
        */
        System.out.println(finalSet[0][0].getFoundProductName() + " " + finalSet[0][0].getFoundProductTotalPrice());
        System.out.println(finalSet[0][1].getFoundProductName() + " " + finalSet[0][1].getFoundProductTotalPrice());
        System.out.println(finalSet[0][2].getFoundProductName() + " " + finalSet[0][2].getFoundProductTotalPrice());

        System.out.println(" ");

        System.out.println(finalSet[1][0].getFoundProductName() + " " + finalSet[1][0].getFoundProductTotalPrice());
        System.out.println(finalSet[1][1].getFoundProductName() + " " + finalSet[1][1].getFoundProductTotalPrice());
        System.out.println(finalSet[1][2].getFoundProductName() + " " + finalSet[1][2].getFoundProductTotalPrice());

        System.out.println(" ");

        System.out.println(finalSet[2][0].getFoundProductName() + " " + finalSet[2][0].getFoundProductTotalPrice());
        System.out.println(finalSet[2][1].getFoundProductName() + " " + finalSet[2][1].getFoundProductTotalPrice());
        System.out.println(finalSet[2][2].getFoundProductName() + " " + finalSet[2][2].getFoundProductTotalPrice());
    }
}
