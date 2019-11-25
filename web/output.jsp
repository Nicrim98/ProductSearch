<%--
  Created by IntelliJ IDEA.
  User: hp-pc
  Date: 17.11.2019
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Form</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>

  <div class="container">
    <header>
      <h1>Search products</h1>
    </header>
    <main>
      
      <fieldset class="segment1">
        <legend>First best offer</legend>
          <div class="inputField">
                <%-- Lepiej będzie użyć CSS, ale jak na razie na zwykłe wyświetlanie to daje radę :) --%>
              <p><b>Product name: </b> ${productName1_1} <b>Price: </b>${price1_1} <b>Sklep: </b><a href="${url1_1}">link</a></p>
            <p>Product name: ${productName1_2} </p>
            <p>Product name: ${productName1_3} </p>
            <p>Product name: ${productName1_4} </p>
            <p>Product name: ${productName1_5} </p>

          </div>
      </fieldset>

      <fieldset class="segment2">
         <legend>Second best offer</legend>
          <div class="inputField">

              <p>Product name: ${productName2_1} Price: ${price2_1}</p>
              <p>Product name: ${productName2_2} </p>
              <p>Product name: ${productName2_3} </p>
              <p>Product name: ${productName2_4} </p>
              <p>Product name: ${productName2_5} </p>

          </div>
        </fieldset>

      <fieldset class="segment3" onclick="hide()">
         <legend>Third best offer</legend>
          <div id="3" class="inputField">

              <p>Product name: ${productName3_1} Price: ${price3_1}</p>
              <p>Product name: ${productName3_2} </p>
              <p>Product name: ${productName3_3} </p>
              <p>Product name: ${productName3_4} </p>
              <p>Product name: ${productName3_5 } </p>

          </div>
      </fieldset>

    </main>
  </div>
  <script>
      function hide() {
          var x = document.getElementById("3");
          if (x.style.display === "none") {
              x.style.display = "block";
          } else {
              x.style.display = "none";
          }
      }
  </script>
  </body>
</html>


