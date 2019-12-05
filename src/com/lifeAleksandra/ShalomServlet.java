package com.lifeAleksandra;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/parameters")
        //(name = "ShalomServlet", urlPatterns = {"/parameters"})
public class ShalomServlet extends HttpServlet {


    protected String productName;
    protected int amount;
    public static String minPrice;
    public static String maxPrice;
    public static String reputation;
    protected int counter = 0;
    protected final int zestawienia = 3;
    protected int zestawienia_cut = 3;  // domyślnie 3 zestawień są wyświetlane, ale w razie braku opcji dla produktów, zestawienie jest ucinane

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)    throws ServletException, IOException {

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)	throws ServletException, IOException {

        // Processing the form
        PrintWriter writer = response.getWriter();

        // INPUT of user data
        String[] products = request.getParameterValues("productName");
        String[] amounts =request.getParameterValues("amount");
        String[] minPrices =request.getParameterValues("minPrice");
        String[] maxPrices =request.getParameterValues("maxPrice");

        Product[] pr = new Product[5];      // domyślnie 5 produktów użytkownik może próbować szukać
        counter = 0;    // variable count how many products where inserted into form
        // creating objects - products from class Product
        for(int i=0; i<5; i++){
            if(products[i] != "") {     //product's name is "" by default, so if the name was given in form, the product will be inserted into pr
                pr[i] = new Product(products[i], Integer.parseInt(amounts[i]), Float.parseFloat(minPrices[i]), Float.parseFloat(maxPrices[i]))                                                                                                                                         ;
                counter++;
            }
            else{
                break;
            }
        }

        Set s = new Set();
        FoundProduct[][] readySets = s.makeSets(pr, counter);

        //show search result, open existing .jsp file
        String destination = "output.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);

        // Zapewnienie wyświetlania tylko zestawień, gdzie wszystkie produkty mają swoje warianty cenowe ;)
        System.out.println(counter + " ile produktów użytkownika zliczyłem");
        System.out.println(zestawienia_cut + " ile zestawień wyświetle");
        zestawienia_cut = 3;
        for(int i=0; i < counter; i++){
            for(int j=0; j < 5; j++) {
                if (readySets[i][j] == null) {
                    if ( j < zestawienia_cut) {
                        zestawienia_cut = j;
                    }
                }
            }
        }

        System.out.println(zestawienia_cut + "max zestawien");
        float[] totalPriceTmp = new float[3];

        for(int i=0; i < counter; i++) {    // liczba produktów
            for(int j=0; j < zestawienia_cut; j++) {

                if(readySets[i][j] != null){
                    String productNameTmp = "productName"+i+"_"+j;      // tworzenie odpowiednich zmiennych html
                    String priceTmp = "price"+i+"_"+j;
                    String urlTmp = "url"+i+"_"+j;

                    request.setAttribute(productNameTmp, readySets[i][j].foundProductName);
                    request.setAttribute(priceTmp, readySets[i][j].foundProductTotalPrice);
                    request.setAttribute(urlTmp, readySets[i][j].url);
                    totalPriceTmp[j] = totalPriceTmp[j] + readySets[i][j].foundProductTotalPrice;
                }

            }
        }

        for(int i=0; i<zestawienia_cut; i++) {  // ustawienie pola ceny za zestaw
            String setPrice = "setPrice"+i;
            request.setAttribute(setPrice, totalPriceTmp[i]);
        }

        requestDispatcher.forward(request, response);   // wyświetlanie wyników

    }
}

