<%--
  Created by IntelliJ IDEA.
  User: hp-pc
  Date: 29.11.2019
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS for styling and layout-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body class="bg-gradient-success" background="https://www.mineralart.pl/static/mineralart/images/products/375x535/tlo-fotograficzne-cegly-czarne-szare-mur-50x100-12907.jpg">
<div class="container d-flex justify-content-center p-5">  <!--  -->
    <div class="row">
        <div class="col" >
            <form name="ShalomServlet" method="get" action="parameters">
                <div class="card" style="width: 25rem;">
                    <ul class="list-group list-group-flush" id="myForm">
                        <li class="list-group-item">
                            <div class="form-group">
                                <%--@declare id="productname"--%><label for="productName">Product name:
                                </label>
                                <input type="text" class="form-control border border-dark" id="name1">
                            </div>
                            <div class="form-group">
                                <%--@declare id="amount"--%><label for="amount">Amount: </label>
                                <input type="number" min=1 class="form-control border border-dark" id="amount1">
                            </div>
                            <div class="form-group">
                                <%--@declare id="minprice"--%><label for="minPrice">Minimum price: </label>
                                <input type="number" class="form-control border border-dark" id="min1">
                            </div>
                            <div class="form-group">
                                <%--@declare id="maxprice"--%><label for="maxPrice">Maximum price: </label>
                                <input type="number" class="form-control border border-dark" id="max1">
                            </div>
                        </li>

                    </ul>
                    <button type="submit" class="btn btn-primary" id="searchButton">Szukaj</button>


                </div>
            </form>

            <button onclick="addProduct('Product name', 'Amount', 'Minimum price', 'Maximum price')" class="btn btn-primary">Add next product</button>



        </div>
    </div>
</div>
<script>
    function addProduct(name, name1, name2, name3){

        var li = document.createElement("LI");
        var div = document.createElement("div");
        var div1 = document.createElement("div");
        var div2 = document.createElement("div");
        var div3 = document.createElement("div");
        var label = document.createElement("label");
        var label1 = document.createElement("label");
        var label2 = document.createElement("label");
        var label3 = document.createElement("label");
        var input = document.createElement("input");
        var input1 = document.createElement("input");
        var input2 = document.createElement("input");
        var input3 = document.createElement("input");
        var textnode = document.createTextNode(name+" :");
        var textnode1 = document.createTextNode(name1+" :");
        var textnode2 = document.createTextNode(name2+" :");
        var textnode3 = document.createTextNode(name3+" :");


        li.className = "list-group-item";
        div.className = "form-group";
        div1.className = "form-group";
        div2.className = "form-group";
        div3.className = "form-group";
        input.className = "form-control border border-dark";
        input1.className = "form-control border border-dark";
        input2.className = "form-control border border-dark";
        input3.className = "form-control border border-dark";

        label.appendChild(textnode);
        div.appendChild(label);
        div.appendChild(input);
        li.appendChild(div);

        label1.appendChild(textnode1);
        div1.appendChild(label1);
        div1.appendChild(input1);
        li.appendChild(div1);

        label2.appendChild(textnode2);
        div2.appendChild(label2);
        div2.appendChild(input2);
        li.appendChild(div2);

        label3.appendChild(textnode3);
        div3.appendChild(label3);
        div3.appendChild(input3);
        li.appendChild(div3);

        document.getElementById("myForm").appendChild(li);
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
