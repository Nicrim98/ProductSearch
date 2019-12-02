package com.lifeAleksandra;

import java.util.ArrayList;

public class Sort {
    public static void merge(ArrayList<FoundProduct> a, ArrayList<FoundProduct> l, ArrayList<FoundProduct> r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if(l.get(i).isItBetter(l.get(i),r.get(i))){
                a.set(k++,l.get(i++));
            }else{
                a.set(k++,r.get(j++));
            }
        }
        while(i < left){
            a.set(k++,l.get(i++));
        }
        while(j < right){
            a.set(k++,r.get(j++));
        }



    }
    public  void mergeSort(ArrayList<FoundProduct> lista) {
        int ammount = lista.size();
        if (ammount < 2) {
            return;
        }
        int mid = ammount / 2;
        ArrayList<FoundProduct> l = new ArrayList<FoundProduct>(mid);
        ArrayList<FoundProduct> r = new ArrayList<FoundProduct>(ammount-mid);

        for (int i = 0; i < mid; i++) {
            l.set(i, lista.get(i));
        }
        for (int i = mid; i < ammount; i++) {
            r.set((i-mid),lista.get(i));
        }
        mergeSort(l);
        mergeSort(r);

        merge(lista, l, r, mid, ammount - mid);
    }


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


    public static void buble(Set[] a, int ammount) {
        int change = 1;
        Set temporarySet;
        while (change > 0) {
            change = 0;
            for (int i = 0; i < ammount - 1; i++) {
                if (a[i] != null && a[i + 1] != null) {
                    if (!a[i].isSetBetter(a[i], a[i + 1])) {
                        temporarySet = a[i + 1];
                        a[i + 1] = a[i];
                        a[i] = temporarySet;
                        change++;
                    }
                }
            }
        }
    }
}