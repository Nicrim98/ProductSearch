package com.lifeAleksandra;

public class Compare {

    public Compare() {
    }
    // dostajemy tablice 5 produktów na jeden szukany produkt
    // mamy wszystkie dane tych produktów

    // 3 najlepsze oferty i ich shop id
    // 2 pozostałe oferty i ich shop id

    public FoundProduct[][] check(FoundProduct[][] tmp, int numberOfProducts) {
        FoundProduct[][] final_p = tmp;         // FoundProduct[wariacja cenowa produktu][dany produkt]

        System.out.println(final_p[0][0].shopId);
        for(int i=0; i<5;i++){
            for(int j=0; j<5; j++){

            }
        }
        // tworzenie zestawów teoretycznie najlepszych po cenie, chyba za dużo byłoby roboty z tym
        //FoundProduct[][] zestaw1 = new FoundProduct[][];

        return final_p;
    }
    // jesli dany sklep ma darmową dostawę to najlepsza oferta jeśli min cena
    //
    // liczy sie maksymalna cena za zestaw
}
