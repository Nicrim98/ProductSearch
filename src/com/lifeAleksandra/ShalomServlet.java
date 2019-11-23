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
    public static String amount;
    public static String minPrice;
    public static String maxPrice;
    public static String reputation;

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

      /*  PrintWriter out = response.getWriter();

        productName= request.getParameter("productName");
        amount = request.getParameter("amount");
        minPrice = request.getParameter("minPrice");
        maxPrice = request.getParameter("maxPrice");
        reputation = request.getParameter("reputation");

        ///Product p = new Product(productName, Integer.parseInt(amount), Float.parseFloat(minPrice), Float.parseFloat(maxPrice), Float.parseFloat(reputation));
        //Controller c = new Controller();
        //c.Search(p);


        out.println("Submitted Data");
        out.println("Product Name:"+ productName);
        out.println("Amount:"+ amount);
        out.println("MinPrice:"+ minPrice);
        out.println("MaxPrice:"+ maxPrice);
        out.println("Reputation:"+ reputation);

        HttpSession session = request.getSession();
        session.setAttribute("productName", productName);

        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your's desired product is: " + productName + "<br/>";
        htmlRespone += "<h2>The amount of them is: " + amount + "</h2>";
        htmlRespone += "</html>";

        // return response
        out.println(htmlRespone);
*/
        PrintWriter writer = response.getWriter();

        // Processing the form

        productName = request.getParameter("productName");
        productName += " ALLELLEEEE super !!!";

        Product pr = new Product(productName, 0, 0, 0, 0);

        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your's desired product is: " + pr.getName() + "</h2>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);

    }

}

