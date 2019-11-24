package com.lifeAleksandra;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        /*PrintWriter out = response.getWriter();

        productName = request.getParameter("productName");
        amount = request.getParameter("amount");
        minPrice = request.getParameter("minPrice");
        maxPrice = request.getParameter("maxPrice");
        reputation = request.getParameter("reputation");

        //Product p = new Product(productName, Integer.parseInt(amount), Float.parseFloat(minPrice), Float.parseFloat(maxPrice), Float.parseFloat(reputation));
        //Controller c = new Controller();
        //c.Search(p);

        out.println("Received Data");
        out.println(productName);
        out.println(amount);
        out.println(minPrice);
        out.println(maxPrice);
        out.println(reputation);
        */

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)	throws ServletException, IOException {


        PrintWriter writer = response.getWriter();

        // Processing the form
        // making String table Si -> Array
        String[] products = request.getParameterValues("productName");
        String[] amounts =request.getParameterValues("amount");
        String[] minPrices =request.getParameterValues("minPrice");
        String[] maxPrices =request.getParameterValues("maxPrice");
        String[] reputations =request.getParameterValues("reputation");

        Product[] pr = new Product[5];

        // creating objects - products from class Product
        for(int i=0; i<5; i++){
            if(products[i] != "") {
                pr[i] = new Product(products[i], Integer.parseInt(amounts[i]), Float.parseFloat(minPrices[i]), Float.parseFloat(maxPrices[i]), Float.parseFloat(reputations[i]));
                counter++;
            }
            else{
                break;
            }
        }


        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your's desired product is: " + pr[1].getName() + "</h2>";
        htmlRespone += "<h3>In number of: " + pr[1].getAmount() + "</h3>";
        htmlRespone += "<h4>How many products entered: " + counter + "</h4>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);

    }

}

