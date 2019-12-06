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
      <form name="ShalomServlet" method="post" action="parameters" >
        <%-- zamienienie metody na post zamiast get, i w action zamienienie całego url --%>
      <fieldset class="segment1">
        <legend class="legend">Product I:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input id="name1" name="productName" type="text" value="" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input id="amount1" name="amount" type="number" min="1" step="1" required></input>
              <%--minimum ustawione na 1, bo 0 produktów to tak średnio, dla pozostałych segmentów też zmienione już--%>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input id="min1" name="minPrice" type="number" min="0" step="0.1" required></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input id="max1" name="maxPrice" type="number" min="0" step="0.1" required></input>
          </div>

      </fieldset>

      <fieldset class="segment2">
        <legend class="legend">Product II:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input id="name2" name="productName" type="text" value=""></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input id="amount2" name="amount" type="number" min="1" step="1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input id="min2" name="minPrice" type="number" min="0" step="0.1"></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input id="max2" name="maxPrice" type="number" min="0" step="0.1"></input>
          </div>

      </fieldset>

      <fieldset class = "segment3">
        <legend class="legend">Product III:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input id="name3" name="productName" type="text" value=""></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input id="amount3" name="amount" type="number" min="1" step="1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input id="min3" name="minPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input id="max3" name="maxPrice" type="number" min="0" step="0.1" ></input>
          </div>

      </fieldset>

      <fieldset class = "segment4">
        <legend>Product IV:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input id="name4" name="productName" type="text" value=""></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input id="amount4" name="amount" type="number" min="1" step="1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input id="min4" name="minPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input id="max4" name="maxPrice" type="number" min="0" step="0.1" ></input>
          </div>

      </fieldset>

      <fieldset class = segment5>
        <legend>Product V:</legend>
          <div class="inputField">
            <%--@declare id="productname"--%><label for="productName" class="inputLabel">Product's name: </label>
            <input id="name5" name="productName" type="text" value=""></input>
          </div>

          <div class="inputField">
            <%--@declare id="amount"--%><label for="amount" class="inputLabel">Amount: </label>
            <input id="amount5" name="amount" type="number" min="1" step="1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="minprice"--%><label for="minPrice" class="inputLabel">Minimum price [pln]: </label>
            <input id="min5" name="minPrice" type="number" min="0" step="0.1" ></input>
          </div>

          <div class="inputField">
            <%--@declare id="maxprice"--%><label for="maxPrice" class="inputLabel">Maximum price [pln]: </label>
            <input id="max5" name="maxPrice" type="number" min="0" step="0.1" ></input>
          </div>

      </fieldset>

      <div class="segment6">
        <div class="button">
          <br>
          <input id="submitBtn" type="submit" value="Search" onclick="check();validate();" ></input>
          <br><br><br>
          <input id="clear" type="reset" value="Clear">
        </div>
      </div>
      </form>

    </main>
  </div>

  <script>
    // działa ale tylko dla jednego boxa jak na razie

    function validate() {
        var i;
        for (i = 2; i <= 5; i++) {
            var nameTmp = "name" + i;
            var amountTmp = "amount" + i;
            var minTmp = "min" + i;
            var maxTmp = "max" + i;
            var reputationTmp = "reputation" + i;
            if(document.getElementById(nameTmp).value != ""){
                document.getElementById(nameTmp).required = true;
                document.getElementById(amountTmp).required = true;
                document.getElementById(minTmp).required = true;
                document.getElementById(maxTmp).required = true;
                document.getElementById(reputationTmp).required = true;
            }
            else{
                document.getElementById(nameTmp).required = false;
                document.getElementById(amountTmp).required = false;
                document.getElementById(minTmp).required = false;
                document.getElementById(maxTmp).required = false;
                document.getElementById(reputationTmp).required = false;
            }
        }
    }

    function check() {
        var i;
        for (i = 1; i <= 5; i++) {
            var minTmp = "min" + i;
            var maxTmp = "max" + i;
            var minPr = parseFloat(document.getElementById(minTmp).value);
            var maxPr = parseFloat(document.getElementById(maxTmp).value);

            if (minPr > maxPr) {
                alert("Maximum price must be greater than minimum price!");
                alert(minPr + "    " + maxPr);
                document.getElementById(maxTmp).value = '';
            } else {
                // input is fine
            }
        }
        //var minPr = document.getElementById("segment1.min").value;
     /*
      var maxPr = document.getElementById("max").value;

      if (minPr > maxPr) {
        alert("Maximum price must be greater than minimum price!");
          document.getElementById('max').value = '';
      } else {
        // input is fine
      }*/
    }
  </script>

  </body>
</html>


