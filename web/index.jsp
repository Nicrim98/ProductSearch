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

  <script>
    // na razie nie działa, użycie js żeby cen maksymalna wprowadzona przez użytkownika nie był mniejsza od minimalnej
    // wprowadziłem do tego id w pierwszym segmencie do wypróbowania tej funkcji
    function check(input) {
      var maxPr = document.getElementById("max").values();
      var minPr = document.getElementById("min").values();
      if (minPr >= maxPr) {
        input.setCustomValidity('Maximum price must be greater than minimum price');
      } else {
        // input is fine -- reset the error message
        input.setCustomValidity('');
      }
    }
  </script>

  <div class="container">
    <header>
      <h1>Search products</h1>
    </header>
    <main>
      <form name="ShalomServlet" method="post" action="parameters" >
        <%-- zamienienie metody na post zamiast get, i w action zamienienie całego url --%>
      <fieldset class="segment1">
        <legend>Product I:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" value="" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="1" step="1" required></input>
              <%--minimum ustawione na 1, bo 0 produktów to tak średnio, dla pozostałych segmentów też zmienione już--%>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input id="min" name="minPrice" type="number" min="0" step="0.1" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input id="max" name="maxPrice" type="number" min="0" step="0.1" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="reputation"--%><label for="reputation" class="inputLabel">Reputation [stars]: </label>
            <input name="reputation" type="number" min="0"  max="5" step="0.5" required></input>
          </div>
      </fieldset>

      <fieldset class="segment2">
        <legend>Product II:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" value=""></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="1" step="1"></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input name="minPrice" type="number" min="0" step="0.1"></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input name="maxPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="reputation"--%><label for="reputation" class="inputLabel">Reputation [stars]: </label>
            <input name="reputation" type="number" min="0" max="5" step="0.5" ></input>
          </div>
      </fieldset>

      <fieldset class = "segment3">
        <legend>Product III:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" value=""></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="1" step="1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input name="minPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input name="maxPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="reputation"--%><label for="reputation" class="inputLabel">Reputation [stars]: </label>
            <input name="reputation" type="number" min="0" max="5" step="0.5" ></input>
          </div>
      </fieldset>

      <fieldset class = "segment4">
        <legend>Product IV:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" value=""></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="1" step="1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input name="minPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input name="maxPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="reputation"--%><label for="reputation" class="inputLabel">Reputation [stars]: </label>
            <input name="reputation" type="number" min="0" max="5" step="0.5" ></input>
          </div>
      </fieldset>

      <fieldset class = segment5>
        <legend>Product V:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" value=""></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="1" step="1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input name="minPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input name="maxPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="reputation"--%><label for="reputation" class="inputLabel">Reputation [stars]: </label>
            <input name="reputation" type="number" min="0" max="5" step="0.5" ></input>
          </div>
      </fieldset>

      <div class="segment6">
        <div class="button">
          <br>
          <input id="submitBtn" type="submit" value="Search"></input>
          <br><br><br>
          <input id="clear" type="reset" value="Clear">
        </div>
      </div>
      </form>

    </main>
  </div>
  </body>
</html>


