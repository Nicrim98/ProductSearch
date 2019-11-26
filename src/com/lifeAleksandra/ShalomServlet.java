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
        String[] reputations =request.getParameterValues("reputation");

        Product[] pr = new Product[5];
        counter = 0;    // variable count how many products where inserted into form
        // creating objects - products from class Product
        for(int i=0; i<5; i++){
            if(products[i] != "") {     //product's name is "" by default, so if the name was given in form, the product will be inserted into pr
                pr[i] = new Product(products[i], Integer.parseInt(amounts[i]), Float.parseFloat(minPrices[i]), Float.parseFloat(maxPrices[i]), Float.parseFloat(reputations[i]));
                counter++;
            }
            else{
                break;
            }
        }

        // web crawling for user's desired products
        WebCrawler web = new WebCrawler();
        FoundProduct[] options = new FoundProduct[zestawienia];
        FoundProduct[][] results = new FoundProduct[zestawienia][5];
        // tworzymy zetawienia więc [3] <- max. ilość zestawień, [5] <- max. ilość poszukiwanych produktów

        for(int i=0; i < counter; i++) {

            try {
                options = web.Search(pr[i]);     // load best 3 options for the product[number of product]
            } catch (IOException e) {
                e.printStackTrace();
            }                               // 0,1,2 <- odpowiednie zestawienia
            results[0][i] = options[0];     // do pierwszego zestawienia opcja 1  // options[0] <- najlepsza oferta
            results[1][i] = options[1];     // do drugiego zestawienia opcja 2
            results[2][i] = options[2];     // do trzeciego zestawienia opcja 3
        }


        //show search result, open existing .jsp file
        String destination = "output.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);

        for(int i=0; i < counter; i++) {
            for(int j=0; j < zestawienia; j++) {
                if(results[j][i] != null){
                    String productNameTmp = "productName"+j+"_"+i;      // tworzenie odpowiednich zmiennych html
                    String priceTmp = "price"+j+"_"+i;
                    String urlTmp = "url"+j+"_"+i;

                    request.setAttribute(productNameTmp, results[j][i].foundProductName);
                    request.setAttribute(priceTmp, results[j][i].foundProductPrice);
                    request.setAttribute(urlTmp, results[j][i].url);
                }
            }
        }

        requestDispatcher.forward(request, response);   // wyświetlanie

    }
}

