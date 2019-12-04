package com.lifeAleksandra;

import java.io.IOException;
import java.util.ArrayList;

public class Set{
    // DLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA OLIIIIIIIIIIIIIIIIIIIIIIIIIIIII <3
    // klasa która będzie zbierać zestawienia produktów
    // sets[0][] / sets[1][] / set[2][] <- set0 najlepszy itd.

    // utworzenie tych defaultowych setsów pomoże moim zdaniem do łatwiejszego wyświetlania
    // wyświetlania lepszego, bo nie będziemy brać wszystkich kolejnych produktów tylko jeden produkt będzie się różnił ceną

    // następnie w klasie Compare zamierzam patrzeć na id_sklepu i sprawdzać wtedy jeszcze tą dostawę w przypadku tego samego sklepu
    protected final int numberOfSets = 5;
    protected float priceForSet;
    protected float[] priceSet= new float[5];


    protected ArrayList<Integer> shopIDs = new ArrayList<>();

    public Set() {
    }

    public Set(FoundProduct[] f, float priceForSet) {
        this.priceForSet = priceForSet;
    }

   /* public void run(WebCrawler web, Product p, FoundProduct[] options) {
        try {
            options = web.Search(p, 5);     // load best 3 options for the product[number of product]
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    */

    public FoundProduct[][] makeSets(Product[] p, int numberOfProducts) {

        WebCrawler web = new WebCrawler();
        ArrayList<FoundProduct> options = new ArrayList<FoundProduct>(5);   // 5 najlepszych opcji dostajemy od webcrawlera
        FoundProduct[][] sets = new FoundProduct[numberOfProducts][5];  // wybiermay 3 zestawy z wyszukiwanych produktów
        FoundProduct[][] finalSet = new FoundProduct[numberOfProducts][3];

        // tworzenie zestawiń (domyślnie najlepszych bez patrzenia czy produkty z tego samego sklepu)
        for (int i = 0; i < numberOfProducts; i++) {

            try {
                options = web.Search(p[i], 5);     // load best 3 options for the product[number of product]
            } catch (IOException e) {
                e.printStackTrace();
            }
            // przyporządkowanie produktów znalezionych przez crawlera do zestawień
            for (int j = 0; j < options.size() && j < 5; j++) {

                    sets[i][numberOfSets - (5 - j)] = options.get(j);
                    shopIDs.add(options.get(j).shopId);
                    priceSet[i] += options.get(j).getFoundProductTotalPrice();    // zliczanie ceny za zestaw, tylko dla trzech pierwszych, bo tylko 3 zestawienia końcow

            }
        }
        Compare compare = new Compare();
        finalSet = compare.check(sets, numberOfProducts, shopIDs, priceSet[0], priceSet[1], priceSet[2]);

            // TO DO:
            // załatwienie case'a, że jeśli nie mamy jakiejś opcji produktu, ale mamy jakieś w ogóle to zwróć w to miejsce najlepszą opcje dla tego produktu

            return finalSet;
    }

    public boolean isSetBetter(Set firstSet, Set secondSet) {

        if (firstSet.priceForSet < secondSet.priceForSet) {
            return true;
        } else {
            return false;
        }
    }
}