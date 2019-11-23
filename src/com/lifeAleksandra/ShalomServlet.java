package com.lifeAleksandra;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShalomServlet", urlPatterns = {"/parameters"})
public class ShalomServlet extends HttpServlet {


    protected String productName;
    public static String amount;
    public static String minPrice;
    public static String maxPrice;
    public static String reputation;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)    throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        productName = request.getParameter("productName");
        amount = request.getParameter("amount");
        minPrice = request.getParameter("minPrice");
        maxPrice = request.getParameter("maxPrice");
        reputation = request.getParameter("reputation");

        Product p = new Product(productName, Integer.parseInt(amount), Float.parseFloat(minPrice), Float.parseFloat(maxPrice), Float.parseFloat(reputation));
        Controller c = new Controller();
        c.Search(p);

        out.println("Received Data");
        out.println(productName);
        out.println(amount);
        out.println(minPrice);
        out.println(maxPrice);
        out.println(reputation);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)	throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        productName= request.getParameter("productName");
        amount = request.getParameter("amount");
        minPrice = request.getParameter("minPrice");
        maxPrice = request.getParameter("maxPrice");
        reputation = request.getParameter("reputation");

        Product p = new Product(productName, Integer.parseInt(amount), Float.parseFloat(minPrice), Float.parseFloat(maxPrice), Float.parseFloat(reputation));
        Controller c = new Controller();
        c.Search(p);


        out.println("Submitted Data");
        out.println("Product Name:"+ request.getParameter("productName"));
        out.println("Amount:"+request.getParameter("amount"));
        out.println("MinPrice:"+request.getParameter("minPrice"));
        out.println("MaxPrice:"+request.getParameter("maxPrice"));
        out.println("Reputation:"+request.getParameter("reputation"));


    }

}

