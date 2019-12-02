package com.lifeAleksandra;

import java.io.IOException;
import java.util.ArrayList;

public class Set implements Runnable{
    // klasa która będzie zbierać zestawienia produktów
    // sets[0][] / sets[1][] / set[2][] <- set0 najlepszy itd.

    // utworzenie tych defaultowych setsów pomoże moim zdaniem do łatwiejszego wyświetlania
    // wyświetlania lepszego, bo nie będziemy brać wszystkich kolejnych produktów tylko jeden produkt będzie się różnił ceną

    // następnie w klasie Compare zamierzam patrzeć na id_sklepu i sprawdzać wtedy jeszcze tą dostawę w przypadku tego samego sklepu
    protected final int numberOfSets = 5;
    protected float priceSet1 = 0;
    protected float priceSet2 = 0;
    protected float priceSet3 = 0;

    protected ArrayList<Integer> shopIDs = new ArrayList<>();

    public Set(){
    }

   /* public void run(WebCrawler web, Product p, FoundProduct[] options) {
        try {
            options = web.Search(p, 5);     // load best 3 options for the product[number of product]
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    */

    public FoundProduct[][] makeSets(Product[] p, int numberOfProducts){

        WebCrawler web = new WebCrawler();
        ArrayList<FoundProduct> options = new ArrayList<FoundProduct>(5);   // 5 najlepszych opcji dostajemy od webcrawlera
        FoundProduct[][] sets = new FoundProduct[5][numberOfProducts];  // wybiermay 3 zestawy z wyszukiwanych produktów

        // tworzenie zestawiń (domyślnie najlepszych bez patrzenia czy produkty z tego samego sklepu)
        for(int i=0; i < numberOfProducts; i++) {

            try {
                options = web.Search(p[i], 5);     // load best 3 options for the product[number of product]
            } catch (IOException e) {
                e.printStackTrace();
            }
            sets[numberOfSets - 5][i] = options.get(0);
            shopIDs.add(options.get(0).shopId);
            priceSet1 += options.get(0).getFoundProductTotalPrice();    // zliczanie ceny za zestaw, tylko dla trzech pierwszych, bo tylko 3 zestawienia końcowe
            sets[numberOfSets - 4][i] = options.get(1);
            shopIDs.add(options.get(1).shopId);
            priceSet2 += options.get(1).getFoundProductTotalPrice();
            sets[numberOfSets - 3][i] = options.get(2);     // Najlepsze zestawienie czytaj najtańsze (webcrawler zwraca posortowane od najtańszego)
            shopIDs.add(options.get(2).shopId);
            priceSet3 += options.get(2).getFoundProductTotalPrice();
            sets[numberOfSets - 2][i] = options.get(3);     // 2 najlepsze zestawienie
            shopIDs.add(options.get(3).shopId);
            sets[numberOfSets - 1][i] = options.get(4);     // ostatnine zestawienie
            shopIDs.add(options.get(4).shopId);

            //Compare compare = new Compare();
            //compare.check();
            // compare XD
        }
        return sets;
    }

    @Override
    public void run(){
    }
}