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
        FoundProduct[] test = new FoundProduct[3];

        try {
            test = web.Test(pr[0]);     // load best 3 options for the product
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2 methods to show search result, open existing .jsp file
        String destination = "output.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);

        request.setAttribute("productName1_1", test[0].foundProductName);
        request.setAttribute("price1_1", test[0].foundProductPrice);
        request.setAttribute("url1_1", test[0].url);
        request.setAttribute("productName2_1", test[1].foundProductName);

        requestDispatcher.forward(request, response);

        // OUTPUT
        // output.jsp will be html file fot the outcome of web crawling
        // or build HTML code and display
       /* String htmlRespone = "<html>";
        htmlRespone += "<h2>Your's desired product is: " + test[0].getFoundProductName() + "</h2>";
        htmlRespone += "<h3>In number of: " +  test[1].getFoundProductName() + "</h3>";
        htmlRespone += "<h4>How many products entered: " +  test[2].getFoundProductName() + "</h4>";
       // htmlRespone += "<h5>Web crawler... " + str + "</h5>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);
*/
    }
}

