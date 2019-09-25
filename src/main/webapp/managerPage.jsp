<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<html lang="en">
<head>
    <title>Index</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="libs/images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="libs/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="libs/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="libs/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="libs/vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="libs/vendor/animsition/css/animsition.min.css">
    <link rel="stylesheet" type="text/css" href="libs/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="libs/vendor/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" type="text/css" href="libs/css/util.css">
    <link rel="stylesheet" type="text/css" href="libs/css/main.css">

    <style>table {
        border-collapse: separate;
        border-spacing: 15px 0;
    }

    td {
        padding: 10px 0;
    }

    .btn-link{
        border:none;
        outline:none;
        background:none;
        cursor:pointer;
        color:#0000EE;
        padding:0;
        text-decoration:underline;
        font-family:inherit;
        font-size:inherit;
    }

    </style>

</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <%--<form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="/" method="get">--%>
            <div class="login100-form validate-form p-l-55 p-r-55 p-t-178">
					<span class="login100-form-title">
                        Available cars
					</span>

                <div class="text-left p-t-1 p-b-15">
                    <span class="txt1">
                        SORT BY
                    </span>
                    <form action="/show" method="get">
                        <button type="submit" name="sortBy" value="brand" class="txt2">brand</button>
                        /
                        <button type="submit" name="sortBy" value="name" class="txt2">name</button>
                        /
                        <button type="submit" name="sortBy" value="category" class="txt2">category</button>
                        /
                        <button type="submit" name="sortBy" value="price" class="txt2">price</button>

                    </form>
                </div>

                <table>
                    <tr align="left">
                        <%--<th>id</th>--%>
                        <th>brand</th>
                        <th>name</th>
                        <th>category</th>
                        <th>$/day</th>
                    </tr>
                    <c:forEach var="car" items="${cars}">
                        <tr>
                                <%--<td>${car.id}</td>--%>
                            <td>${car.brand}</td>
                            <td>${car.name}</td>
                            <td>${car.category}</td>
                            <td align="right">${car.price}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br>

                <div class="text-left p-t-13 p-b-23">
                    <span class="txt1">
                        SELECT ONLY
                    </span>
                    <form action="/show" method="get">
                        <button type="submit" name="selectBy" value="brand" class="txt2">brand</button>
                        /
                        <button type="submit" name="selectBy" value="category" class="txt2">category</button>
                    </form>
                </div>

                <div class="text-right p-t-13 p-b-23">
						<span class="txt1">
							Go to
						</span>

                    <a href="addCar.jsp" class="txt2">
                        addCar.jsp
                    </a>
                </div>

                <form  action="/index.jsp" method="get">
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn">
                            Home
                        </button>
                    </div>

                </form>


                <div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
							Already have an account?
						</span>

                    <a href="/login.jsp" class="txt3">
                        Sign in
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="libs/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="libs/vendor/animsition/js/animsition.min.js"></script>
<script src="libs/vendor/bootstrap/js/popper.js"></script>
<script src="libs/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="libs/vendor/select2/select2.min.js"></script>
<script src="libs/vendor/daterangepicker/moment.min.js"></script>
<script src="libs/vendor/daterangepicker/daterangepicker.js"></script>
<script src="libs/vendor/countdowntime/countdowntime.js"></script>
<script src="libs/js/main.js"></script>
</body>
</html>