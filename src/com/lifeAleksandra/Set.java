package com.lifeAleksandra;

import java.io.IOException;
import java.util.ArrayList;

public class Set {
    // klasa która będzie zbierać zestawienia produktów
    // sets[0][] / sets[1][] / set[2][] <- set0 najlepszy itd.

    // utworzenie tych defaultowych setsów pomoże moim zdaniem do łatwiejszego wyświetlania
    // wyświetlania lepszego, bo nie będziemy brać wszystkich kolejnych produktów tylko jeden produkt będzie się różnił ceną

    // następnie w klasie Compare zamierzam patrzeć na id_sklepu i sprawdzać wtedy jeszcze tą dostawę w przypadku tego samego sklepu
    protected final int numberOfSets = 3;

    public FoundProduct[][] makeSets(Product[] p, int numberOfProducts){

        WebCrawler web = new WebCrawler();
        ArrayList<FoundProduct> options = new ArrayList<FoundProduct>(5);   // 5 najlepszych opcji dostajemy od webcrawlera
        FoundProduct[][] sets = new FoundProduct[3][numberOfProducts];  // wybiermay 3 zestawy z wyszukiwanych produktów



        // tworzenie zestawiń (domyślnie najlepszych bez patrzenia czy produkty z tego samego sklepu)
        for(int i=0; i < numberOfProducts; i++) {

            try {
                options = web.Search(p[i], 5);     // load best 3 options for the product[number of product]
            } catch (IOException e) {
                e.printStackTrace();
            }

            sets[numberOfSets-3][i] = options.get(0);     // Najlepsze zestawienie czytaj najtańsze (webcrawler zwraca posortowane od najtańszego)
            sets[numberOfSets-2][i] = options.get(1);     // 2 najlepsze zestawienie
            sets[numberOfSets-1][i] = options.get(2);     // ostatnine zestawienie
        }

        return sets;
    }
}
