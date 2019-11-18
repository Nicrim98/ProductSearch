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
  </head>
  <body>

  <div class="container">
    <div class="title">
      <form action="http://localhost:8080/pierwszy_war_exploded/parameters" method="get">
      <fieldset>
        <legend>Product I:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="0" step="1" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input name="minPrice" type="text" min="0" step="0.1" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input name="maxPrice" type="text" min="0" step="0.1" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="reputation"--%><label for="reputation" class="inputLabel">Reputation [stars]: </label>
            <input name="reputation" type="text" min="0" step="0.5" required></input>
          </div>
      </fieldset>

      <fieldset>
        <legend>Product II:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text"></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="0" step="1"></input>
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
            <input name="reputation" type="number" min="0" step="0.5" ></input>
          </div>
      </fieldset>

      <fieldset>
        <legend>Product III:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="0" step="1" ></input>
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
            <input name="reputation" type="number" min="0" step="0.5" ></input>
          </div>
      </fieldset>

      <fieldset>
        <legend>Product IV:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="0" step="1" ></input>
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
            <input name="reputation" type="number" min="0" step="0.5" ></input>
          </div>
      </fieldset>

      <fieldset>
        <legend>Product V:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input name="productName" type="text" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input name="amount" type="number" min="0" step="1" ></input>
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
            <input name="reputation" type="number" min="0" step="0.5" ></input>
          </div>
      </fieldset>

      <fieldset>
        <div class="button">
          <input id="submitBtn" type="submit" value="Search"></input>
          <input type="reset" value="clear">
        </div>
      </fieldset>
  </form>
  </div>
  </div>
  </body>
</html>

