package com.lifeAleksandra;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebCrawler{

    public void Search(Product product) throws IOException {

        // pobieranie odp rzeczy w ifach
        //spr ceny zanim wejdzie w link do "comparePriceLink"
        Connection connect = Jsoup.connect("https://www.skapiec.pl/szukaj/w_calym_serwisie/" + product.getName() + "/price"); //pobranie zrodla strony
        Elements webSites; //strony 1.2...3
        //Elements oneLink; //brak opcji porownaj ceny
        //ArrayList<FoundProduct> theBestProducts= new ArrayList<FoundProduct>(3);
        FoundProduct[] theBestProducts = new FoundProduct[3];
        int numberOfProducts =0;

        do {
            Document document = connect.get();
            webSites = document.select("a.pager-btn.arrow.right"); //strong.price.gtm_sor_price //strony z wynikami wyszukiwania 1,2,3...
            //oneLink = document.select("a.more-info");
            // To działa
//            for (Element element : oneLink) {
//                connect = Jsoup.connect("https://www.skapiec.pl" + element.attr("href"));
//                System.out.println("https://www.skapiec.pl" + element.attr("href"));
//                document = connect.get();
//                price = document.select("span.price.gtm_or_price");
//                for (Element elem : price) {
//                    System.out.println(elem.text());
//                }
//            }
            Elements box = document.select("div.box-row.js");
            for (Element box1 : box) {
                Float priceInBox = Float.parseFloat(box1.select("strong.price.gtm_sor_price").text().replace("od ", "").replace(" ", "").replace("zł", "").replace(",", "."));
                if (priceInBox > product.min_price && priceInBox < product.max_price) {
                    Elements comparePriceLink = box1.select("a.compare-link-1");//strona porownaj cene- kilka ofert na Skapiec.pl
                    if (comparePriceLink.text().isEmpty()) {
                        comparePriceLink = box1.select("a.more-info");
                    }
                    connect = Jsoup.connect("https://www.skapiec.pl" + comparePriceLink.attr("href"));
                    document = connect.get();
                    Elements square = document.select("a.offer-row-item.gtm_or_row");
                    for (Element square1 : square) {
                        Elements price = square1.select("span.price.gtm_or_price");
                        String productName = square1.select("span.description.gtm_or_name").text();
                        if (!price.text().isEmpty()) {  //dla stron bez porownaj ceny
                            float floatPrice = Float.parseFloat(price.text().replace(",", ".").replace(" zł", "").replace(" ", ""));
                            if (product.min_price < floatPrice && floatPrice < product.max_price) {
                                Elements numberOfOpinions = square1.select("span.counter");
                                if (!numberOfOpinions.text().isEmpty()) {  //spr czy są "brak opinii"
                                    if (Integer.parseInt(numberOfOpinions.text()) >= 50) { //warunek na ilosc opinii
                                        Elements reputation = square1.select("span.stars.green");  //.span.stars.green
                                        float theBestDeliveryPrice = 1000;
                                        float foundReputation = Float.parseFloat(reputation.attr("style").replace("width: ", "").replace("%", ""));
                                        if (foundReputation >= product.reputation * 100 / 5) {//gwiazdki
                                            Elements url = square1.select("a.offer-row-item.gtm_or_row");
                                            //pobieranie kosztu dostawy
                                            Elements delivery = square1.select("a.delivery-cost.link.gtm_oa_shipping");
                                            //darmowa dostawa
                                            if (delivery.text().isEmpty()) {
                                                theBestDeliveryPrice = 0;
                                                System.out.println("Najtansza dostawa: "+theBestDeliveryPrice);
                                                // tu trzeba dodac wpisanie produktu z cena i linkiem do tablicy
                                                break;
                                            }
                                            String delivery1 = delivery.attr("href");
                                            connect = Jsoup.connect("https://www.skapiec.pl" + delivery1);
                                            document = connect.get();
                                            //sprawdzanie ceny dostawy w zakladkach
                                            String selector = "#product_content > ul > li:nth-child(0) > a";  //trzeba podmieniać (x) na 1,2,4,5 zeby przejsc po zakladkach
                                            for(int i=1; i<6;i++) {
                                                int previousI = i-1;
                                                if(i == 3){
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
                                            if(theBestDeliveryPrice == 1000){
                                                break;
                                            }
                                            String[] id = url.attr("href").split("/");
                                            int shopId = Integer.parseInt(id[3]);
                                            if(numberOfProducts>=0 && numberOfProducts < 3){
                                               // FoundProduct foundProduct1 = new FoundProduct(productName, floatPrice, theBestDeliveryPrice, foundReputation,shopId);
                                                theBestProducts[numberOfProducts] = new FoundProduct(productName, floatPrice, theBestDeliveryPrice, foundReputation,shopId);
                                                numberOfProducts++;
                                            }

                                            if(numberOfProducts>3) {
                                                FoundProduct foundProduct2 = new FoundProduct(productName, floatPrice, theBestDeliveryPrice, foundReputation, shopId);
                                                for (int i = 0; i <= 3; i++) {
                                                    if (foundProduct2.isItBetter(foundProduct2, theBestProducts[i]) == true) {
                                                        theBestProducts[i] = foundProduct2;
                                                    }
                                                }
                                                numberOfProducts++;
                                            }
                               // tu juz mamy url cene produktu i najlepsza cene dostawy
                               // jesli theBestDeliveryPrice == 1000 to znaczy, że nie ma info o koszcie dostawy ale tez nie jest darmowa


                                        }

                                    }

                                }
                            }
                        }
                    }
                }
            }



//            Elements box = document.select("a.box");
//            for (Element element : box){
//                Float box2 = Float.parseFloat(box.select("strong.price.gtm_sor_price").text().replace("od ", "").replace(" zł","").replace(",","."));
//                if(product.min_price <box2 && box2< product.max_price) {
//
//                }
//            }

            for (Element elem : webSites) {
               connect = Jsoup.connect("https://www.skapiec.pl" + elem.attr("href"));
            }


        }while(webSites.size() == 1);

    }


//    public void (Product a, Product b){
//
//    }

    public static void main(String[] args) {
        Product p = new Product("mysz logitech", 1, 30, 40, 4);
        WebCrawler w = new WebCrawler();
        try {
            w.Search(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
