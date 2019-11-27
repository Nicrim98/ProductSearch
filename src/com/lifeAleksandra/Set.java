package com.lifeAleksandra;

public class Set {
    // klasa która będzie zbierać zestawienia produktów
    // set1 / set2 / set3 <- set1 najlepszy itd.

    // utworzenie tych defaultowych setsów pomoże moim zdaniem do łatwiejszego wyświetlania
    // wyświetlania lepszego, bo nie będziemy brać wszystkich kolejnych produktów tylko jeden produkt będzie się różnił ceną

    // następnie w klasie Compare zamierzam patrzeć na id_sklepu i sprawdzać wtedy jeszcze tą dostawę w przypadku tego samego sklepu
    protected final int numberOfSets = 3;

    public Set(){
    }

    public FoundProduct[][] makeSets(FoundProduct[][] tableOfProducts, int numberOfProducts){
        FoundProduct[][] sets = new FoundProduct[3][numberOfProducts];
        // wybór najlepszych opcji do setów, bo wcześniej dawałem 1 opcje jako najlepszą ofertę, 2 jako drugą itd.
        // ale przy większej liczbie produktów to te produkty mogą być te same co w opcji najlepszej a rózniące się
        // tylko jednym elementem i dlatego jest to gorszą opcją
        // dlatego ta klasa miała by je wybierać
        for(int i=0; i < numberOfProducts; i++) {
            sets[0][i] = tableOfProducts[0][i];     // utworzenie najlepszego zestawu, zawsze to będą najlepsze produkty
        }
        // teraz pasuje znaleźć produkt najtańszy z drugich najtańszych produktów i tylko ten produkt podmienić do oferty sets[0]

        System.out.println(sets[0][0]);
        return sets;
    }
}
