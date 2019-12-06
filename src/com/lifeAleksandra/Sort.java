package com.lifeAleksandra;

import java.util.ArrayList;

public class Sort {

    public static void buble(ArrayList<FoundProduct> a) {
        int ammount = a.size();
        int change = 1;
        // a.get(element_miejsce-1 bo od 0)
        FoundProduct temporaryProduct;

        while (change > 0) {
            change = 0;
            for (int i = 0; i < ammount - 1; i++) {
                if (a.get(i) != null && a.get(i + 1) != null) {
                    if (!a.get(i).isItBetter(a.get(i), a.get(i + 1))) {

                        temporaryProduct = a.get(i + 1);
                        a.set(i + 1, a.get(i));
                        a.set(i, temporaryProduct);
                        change++;
                    }
                }
            }
        }
    }




}