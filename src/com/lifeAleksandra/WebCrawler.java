package com.lifeAleksandra;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class WebCrawler {

    protected ArrayList<FoundProduct> listOfProducts = new ArrayList<FoundProduct>();
    protected ArrayList<FoundProduct> finalAnswer = new ArrayList<FoundProduct>();

    public ArrayList<FoundProduct> getFinalAnswer() {
        return finalAnswer;
    }

    public ArrayList<FoundProduct> getListOfProducts() {
        return listOfProducts;
    }

    //funkcja wyszukujaca produkt na stronie Skapiec
    public ArrayList<FoundProduct> Search(Product product, int time) throws IOException {
        listOfProducts.clear();

        Connection connect = Jsoup.connect("https://www.skapiec.pl/szukaj/w_calym_serwisie/" + product.getName()); //pobranie zrodla strony
        Elements webSites; //strony 1,2,3..
        Timestamp start = new Timestamp(System.currentTimeMillis());
        boolean out = false;

        do {
            Document document = connect.get();
            webSites = document.select("a.pager-btn.arrow.right"); //strong.price.gtm_sor_price //strony z wynikami wyszukiwania 1,2,3...
            Elements box = document.select("div.box-row.js");
            ArrayList<Thread> threads = new ArrayList<Thread>();
            for (Element box1 : box) {
                threads.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            SearchBox(box1, product);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }));

            }
            for(Thread t : threads){
                t.run();
                Timestamp end = new Timestamp(System.currentTimeMillis());
                if((end.getTime()-start.getTime())/1000>=time){
                    out = true;
                    break;
                }
            }

            for (Element elem : webSites) {
                connect = Jsoup.connect("https://www.skapiec.pl" + elem.attr("href"));
            }

            if(out){
              break;
            }

        } while (webSites.size() == 1);

        System.out.println("Ile produktow: "+listOfProducts.size());
        //Sortowanie po cenie+wysylka znalezionych produktow
        Sort sort = new Sort();
        sort.buble(listOfProducts);

//        //wybranie 5 najlepszych ofert
//        for(int i = 0; i<5;i++){
//            finalAnswer.add(listOfProducts.get(i));
//        }
//        if(listOfProducts.isEmpty()){
//            Product product1 = new Product(product.name,product.amount,0,100000,product.reputation);
//            Search(product1,1);
//        }
        return listOfProducts;
    }


    //funkcja przeszukujaca poszczegolne boxy z ogolnej strony Skapiec
    public void SearchBox(Element box, Product product) throws IOException {
        //pobranie ceny boxa
        Float priceInBox = Float.parseFloat(box.select("strong.price.gtm_sor_price").text().replace("od ", "").replace(" ", "").replace("zł", "").replace(",", "."));
        if (priceInBox >= product.min_price - 0.1 * product.min_price && priceInBox <= product.max_price) {
            Elements comparePriceLink = box.select("a.compare-link-1");//strona porownaj cene- kilka ofert na Skapiec.pl
            if (comparePriceLink.text().isEmpty()) {
                comparePriceLink = box.select("a.more-info"); //dla stron bez porownaj ceny
            }
            Connection connect = Jsoup.connect("https://www.skapiec.pl" + comparePriceLink.attr("href"));
            Document document = connect.get();
            Elements rectangle = document.select("a.offer-row-item.gtm_or_row");
            //pobieranie informacji ze strony szczegolowej - cena, ilosc opinii, ilosc gwiazdek, koszt dostawy,url produktu
            for (Element square1 : rectangle) {
                float theBestDeliveryPrice = 1000;
                Elements price = square1.select("span.price.gtm_or_price");
                String productName = square1.select("span.description.gtm_or_name").text();
                if (!price.text().isEmpty()) {
                    float floatPrice = Float.parseFloat(price.text().replace(",", ".").replace(" zł", "").replace(" ", ""));
                    if (product.min_price <= floatPrice && floatPrice <= product.max_price) {
                        Elements numberOfOpinions = square1.select("span.counter");
                        if (!numberOfOpinions.text().isEmpty()) {  //spr czy jest "brak opinii"
                            if (Integer.parseInt(numberOfOpinions.text()) >= 50) { //warunek na ilosc opinii
                                Elements reputation = square1.select("span.stars.green");  //.span.stars.green
                                float foundReputation = Float.parseFloat(reputation.attr("style").replace("width: ", "").replace("%", ""));
                                if (foundReputation >= product.reputation * 100 / 5) {//gwiazdki
                                    Elements url = square1.select("a.offer-row-item.gtm_or_row");
                                    String foundUrl = "https://www.skapiec.pl" + url.attr("href");
                                    //pobieranie kosztu dostawy dla każdego produktu "prostokąta na stronie skapiec -> porownaj ceny lub wiecej info jesli nie ma porownaj ceny"
                                    Elements delivery = square1.select("a.delivery-cost.link.gtm_oa_shipping");
                                    //darmowa dostawa
                                    if (delivery.text().isEmpty()) {
                                        theBestDeliveryPrice = 0;
                                        //System.out.println("Najtansza dostawa: " + theBestDeliveryPrice);
                                    } else {
                                        //koszt dostawy != darmowa dostawa
                                        String delivery1 = delivery.attr("href");
                                        connect = Jsoup.connect("https://www.skapiec.pl" + delivery1);
                                        document = connect.get();
                                        //sprawdzanie ceny dostawy w zakladkach Poczta, Kurier itd (bez odbior osobisty)
                                        String selector = "#product_content > ul > li:nth-child(0) > a";  //trzeba podmieniać (x) na 1,2,4,5 zeby przejsc po zakladkach
                                        for (int i = 1; i < 6; i++) {
                                            int previousI = i - 1;
                                            if (i == 3) {
                                                i++;
                                            }
                                            selector = selector.replace(String.valueOf(previousI), String.valueOf(i));
                                            Elements sub = document.select(selector);
                                            connect = Jsoup.connect("https://www.skapiec.pl/delivery.php" + sub.attr("href"));
                                            //System.out.println("https://www.skapiec.pl/delivery.php" + sub.attr("href"));
                                            document = connect.get();
                                            Elements deliveryPrice = document.select("#deliveryRulesets > tbody > tr.even > td:nth-child(2) > div:nth-child(1) > b");
                                            Elements deliveryPrice1 = document.select("#deliveryRulesets > tbody > tr.odd > td:nth-child(2) > div > b");
                                            for (Element deliveryPrice2 : deliveryPrice) {
                                                String p = deliveryPrice2.text().replace(" zł", "");
                                                float actualDeliveryPrice = Float.parseFloat(p);
                                                if (theBestDeliveryPrice > actualDeliveryPrice) {
                                                    theBestDeliveryPrice = actualDeliveryPrice;
                                                }
                                            }
                                            for (Element deliveryPrice2 : deliveryPrice1) {
                                                String p = deliveryPrice2.text().replace(" zł", "");
                                                float actualDeliveryPrice = Float.parseFloat(p);
                                                if (theBestDeliveryPrice > actualDeliveryPrice) {
                                                    theBestDeliveryPrice = actualDeliveryPrice;
                                                }
                                            }
                                        }
                                        //System.out.println("Najlepsza dostawa: "+ theBestDeliveryPrice);
                                    }
                                    //jesli nie darmowa dostawa i brak info o cenie za dostawe
                                    if (theBestDeliveryPrice == 1000) {
                                        break;
                                    }
                                    listOfProducts.add(new FoundProduct(productName, floatPrice, theBestDeliveryPrice, foundReputation, foundUrl));

                                }
                            }
                        }
                    }
                }
            }
        }
    }

        public static void main (String[]args){

            Timestamp start = new Timestamp(System.currentTimeMillis());
            Product p = new Product("klawiatura", 1, 23, 500, 4);
            WebCrawler w = new WebCrawler();
            try {
                w.Search(p,5);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Timestamp end = new Timestamp(System.currentTimeMillis());
            System.out.println("czas: "+(end.getTime()-start.getTime())/1000);
            for(int i=0; i<w.getListOfProducts().size();i++){
                System.out.println(w.getListOfProducts().get(i).getFoundProductTotalPrice());
                System.out.println(w.getListOfProducts().get(i).getFoundProductName());
            }
        }

    }

