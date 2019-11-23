package com.lifeAleksandra;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebCrawler{

    public void Search(Product product) throws IOException{

        // pobieranie odp rzeczy w ifach
        //spr ceny zanim wejdzie w link do "comparePriceLink"
        Connection connect = Jsoup.connect("https://www.skapiec.pl/szukaj/w_calym_serwisie/"+product.name+"/price"); //pobranie zrodla strony
        Elements webSites; //strony 1.2...3
        //Elements oneLink; //brak opcji porownaj ceny
        do {
            Document document = connect.get();
            webSites = document.select("a.pager-btn.arrow.right"); //strong.price.gtm_sor_price //strony z wynikami wyszukiwania 1,2,3...
            //oneLink = document.select("a.more-info");
            System.out.println(webSites.size());
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
                        Elements comperePriceLink = box1.select("a.compare-link-1");//strona porownaj cene- kilka ofert na Skapiec.pl
                        System.out.println(comperePriceLink.text());
                        if(comperePriceLink.text().isEmpty()){
                            comperePriceLink = box1.select("a.more-info");
                            System.out.println("ygfu"+ comperePriceLink.text());
                        }
                        System.out.println(priceInBox);
                        connect = Jsoup.connect("https://www.skapiec.pl" + comperePriceLink.attr("href"));
                        //System.out.println("https://www.skapiec.pl" + comperePriceLink1.attr("href"));
                        document = connect.get();
                        Elements square = document.select("a.offer-row-item.gtm_or_row");
                        for (Element square1 : square) {
                            Elements price = square1.select("span.price.gtm_or_price");
                            if (!price.text().isEmpty()) {
                                float floatPrice = Float.parseFloat(price.text().replace(",", ".").replace(" zł", "").replace(" ", ""));

                                if (product.min_price < floatPrice && floatPrice < product.max_price) {
                                    Elements numberOfOpinions = square1.select("span.counter");
                                    if (!numberOfOpinions.text().isEmpty()) {  //spr czy są brak opinii
                                        if (Integer.parseInt(numberOfOpinions.text()) >= 50) { //warunek na ilosc opinii
                                            Elements reputation = square1.select("span.stars.green");  //.span.stars.green
                                            if (Float.parseFloat(reputation.attr("style").replace("width: ", "").replace("%", "")) >= product.reputation * 100 / 5) {//gwiazdki
                                                Elements url = square1.select("a.offer-row-item.gtm_or_row");
                                                System.out.println("Znalezione strony:");
                                                System.out.println("https://www.skapiec.pl" + url.attr("href"));
                                                //pobieranie kosztu dostawy
                                                Elements delivery = document.select("a.delivery-cost.link.gtm_oa_shipp");
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


    public static void main(String[] args) {
        Product p = new Product("mysz logitech g502", 1, 250, 400, 4);
        WebCrawler w = new WebCrawler();
        try {
            w.Search(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
