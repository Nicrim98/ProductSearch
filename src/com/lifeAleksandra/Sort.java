package com.lifeAleksandra;

import java.util.ArrayList;

public class Sort {
    public static void merge(FoundProduct[] a, FoundProduct[] l, FoundProduct[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i].isItBetter(l[i], r[i])) { // l <= r
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
//    public  void mergeSort(ArrayList<FoundProduct> lista, int ammount = lista.size() ) {
//        if (ammount < 2) {
//            return;
//        }
//        int mid = ammount / 2;
//        FoundProduct[] l = new FoundProduct[mid];
//        FoundProduct[] r = new FoundProduct[ammount - mid];
//
//        for (int i = 0; i < mid; i++) {
//            l[i] = a[i];
//        }
//        for (int i = mid; i < ammount; i++) {
//            r[i - mid] = a[i];
//        }
//        mergeSort(l, mid);
//        mergeSort(r, ammount - mid);
//
//        merge(a, l, r, mid, ammount - mid);
//    }


//    public  void mergeSort(FoundProduct[] a, int ammount) {
//        if (ammount < 2) {
//            return;
//        }
//        int mid = ammount / 2;
//        FoundProduct[] l = new FoundProduct[mid];
//        FoundProduct[] r = new FoundProduct[ammount - mid];
//
//        for (int i = 0; i < mid; i++) {
//            l[i] = a[i];
//        }
//        for (int i = mid; i < ammount; i++) {
//            r[i - mid] = a[i];
//        }
//        mergeSort(l, mid);
//        mergeSort(r, ammount - mid);
//
//        merge(a, l, r, mid, ammount - mid);
//    }

    public static void buble(ArrayList<FoundProduct> a) {
        int ammount = a.size();
        int change = 1;
        // a.get(element_miejsce-1 bo od 0)
        FoundProduct temporaryProduct;

        while (change > 0) {
            change = 0;
            for (int i = 0; i < ammount - 1; i++) {
                if (a.get(i) != null && a.get(i+1) != null) {
                    if (!a.get(i).isItBetter(a.get(i), a.get(i+1))) {

                        temporaryProduct = a.get(i+1);
                        a.set(i+1, a.get(i));
                        a.set(i,temporaryProduct);
                        change++;
                    }
                }
            }
        }
    }


//    public static void buble(FoundProduct[] a, int ammount) {
//        int change = 1;
//        FoundProduct temporaryProduct;
//        while (change > 0) {
//            change = 0;
//            for (int i = 0; i < ammount - 1; i++) {
//                if (a[i] != null && a[i + 1] != null) {
//                    if (!a[i].isItBetter(a[i], a[i + 1])) {
//                        temporaryProduct = a[i + 1];
//                        a[i + 1] = a[i];
//                        a[i] = temporaryProduct;
//                        change++;
//                    }
//                }
//            }
//        }
//    }
}
