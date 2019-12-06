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
<%--    <link rel="stylesheet" href="style.css">--%>
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <!-- Bootstrap CSS for styling and layout-->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  </head>
  <body background="deski.jpg">

  <div class="container">
    <header class="text-primary">
      <h1 class="p-3 font-weight-bold">Search products</h1>
    </header>
    <main>

        <div class="row p-2">
            <div class="col" >
                <div class="bg-light p-2">
                <legend class="font-weight-bold">First best offer</legend>
                  <div class="inputField">
                        <%-- Lepiej będzie użyć CSS bądźbootstrapa, ale jak na razie na zwykłe wyświetlanie to daje radę :) --%>
                    <p ${hid0_0}><b>Product name: </b> ${productName0_0} <b>Price: </b>${price0_0} <b>Shop: </b><a href="${url0_0}" target="_blank">link</a></p>
                    <p ${hid1_0}><b>Product name: </b> ${productName1_0} <b>Price: </b>${price1_0} <b>Shop: </b><a href="${url1_0}" target="_blank" >link</a></p>
                    <p ${hid2_0}><b>Product name: </b> ${productName2_0} <b>Price: </b>${price2_0} <b>Shop: </b><a href="${url2_0}" target="_blank" >link</a></p>
                    <p ${hid3_0}><b>Product name: </b> ${productName3_0} <b>Price: </b>${price3_0} <b>Shop: </b><a href="${url3_0}" target="_blank">link</a></p>
                    <p ${hid4_0}><b>Product name: </b> ${productName4_0} <b>Price: </b>${price4_0} <b>Shop: </b><a href="${url4_0}" target="_blank">link</a></p>
                    <p><b>Total price for whole set: ${setPrice0}</b></p>

                  </div>
              </div>
            </div>
        </div>

        <div class="row p-2">
            <div class="col" >
                <div class="bg-light p-2">
                 <legend class="font-weight-bold">Second best offer</legend>
                  <div class="inputField">

                      <p ${hid0_1}><b>Product name: </b> ${productName0_1} <b>Price: </b>${price0_1} <b>Shop: </b><a href="${url0_1}" target="_blank">link</a></p>
                      <p ${hid1_1}><b>Product name: </b> ${productName1_1} <b>Price: </b>${price1_1} <b>Shop: </b><a href="${url1_1}" target="_blank">link</a></p>
                      <p ${hid2_1}><b>Product name: </b> ${productName2_1} <b>Price: </b>${price2_1} <b>Shop: </b><a href="${url2_1}" target="_blank">link</a></p>
                      <p ${hid3_1}><b>Product name: </b> ${productName3_1} <b>Price: </b>${price3_1} <b>Shop: </b><a href="${url3_1}" target="_blank">link</a></p>
                      <p ${hid4_1}><b>Product name: </b> ${productName4_1} <b>Price: </b>${price4_1} <b>Shop: </b><a href="${url4_1}" target="_blank">link</a></p>
                      <p><b>Total price for whole set: ${setPrice1}</b></p>

                  </div>
                </div>
            </div>
        </div>

                <div class="row p-2">
                    <div class="col" >
                        <div class="bg-light p-2">
                         <legend class="font-weight-bold">Third best offer</legend>
                          <div id="3" class="inputField">

                              <p ${hid0_2}><b>Product name: </b> ${productName0_2} <b>Price with delivery: </b>${price0_2} <b>Shop: </b><a href="${url0_2}" target="_blank">link</a></p>
                              <p ${hid1_2}><b>Product name: </b> ${productName1_2} <b>Price: </b>${price1_2} <b>Shop: </b><a href="${url1_2}" target="_blank">link</a></p>
                              <p ${hid2_2}><b>Product name: </b> ${productName2_2} <b>Price: </b>${price2_2} <b>Shop: </b><a href="${url2_2}" target="_blank">link</a></p>
                              <p ${hid3_2}><b>Product name: </b> ${productName3_2} <b>Price: </b>${price3_2} <b>Shop: </b><a href="${url3_2}" target="_blank">link</a></p>
                              <p ${hid4_2}><b>Product name: </b> ${productName4_2} <b>Price: </b>${price4_2} <b>Shop: </b><a href="${url4_2}" target="_blank">link</a></p>
                              <p><b>Total price for whole set: ${setPrice2}</b></p>

                          </div>
                        </div>
                    </div>
                </div>
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


