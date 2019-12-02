package com.lifeAleksandra;

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

    public  void mergeSort(FoundProduct[] a, int ammount) {
        if (ammount < 2) {
            return;
        }
        int mid = ammount / 2;
        FoundProduct[] l = new FoundProduct[mid];
        FoundProduct[] r = new FoundProduct[ammount - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < ammount; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, ammount - mid);

        merge(a, l, r, mid, ammount - mid);
    }


    public static void buble(FoundProduct[] a, int ammount) {
        int change = 1;
        FoundProduct temporaryProduct;
        while (change > 0) {
            change = 0;
            for (int i = 0; i < ammount - 1; i++) {
                if (a[i] != null && a[i + 1] != null) {
                    if (!a[i].isItBetter(a[i], a[i + 1])) {
                        temporaryProduct = a[i + 1];
                        a[i + 1] = a[i];
                        a[i] = temporaryProduct;
                        change++;
                    }
                }
            }
        }
    }
}
