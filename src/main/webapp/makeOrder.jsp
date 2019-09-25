<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<html lang="en">
<head>
    <title>Order</title>
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

<div>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">

                <form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="/order" method="post">
                            <span class="login100-form-title">
                                Make order
                            </span>
                    <c:set var="car" value="${car}"/>

                   <div>
                       <table>
                           <tr align="left">
                               <th>brand</th>
                               <th>name</th>
                               <th>category</th>
                               <th>$/day</th>
                           </tr>
                           <tr>
                               <td>${car.brand}</td>
                               <td>${car.name}</td>
                               <td>${car.category}</td>
                               <td>${car.price}</td>
                           </tr>
                       </table>
                   </div>
                    <br>

                    <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter DLN">
                        <input name="license" type="text" class="input100" id="inputLicense"
                               placeholder="Driver's license or ID">
                        <span class="focus-input100"></span>
                    </div>

                    <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter term">
                        <input name="term" type="number" class="input100" id="inputDays"
                               placeholder="Term">
                        <span class="focus-input100"></span>
                    </div>
                    <br>

                    <div class="text-md-right p-t-13 p-b-23" data-validate="Please enter withDriver">
                        <input name="withDriver" type="checkbox" id="inputDriver"> with driver
                        <span class="focus-input100"></span>
                    </div>

                    <input type="hidden" name="carId" value="${car.id}">
                    <br>

                    <div class="text-right p-t-13 p-b-23">
                                <span class="txt1">
                                    Return to
                                </span>
                        <a href="index.jsp" class="txt2">
                            home page
                        </a>
                    </div>

                    <div class="container-login100-form-btn">
                        <button type="submit" class="login100-form-btn">
                            Confirm
                        </button>
                    </div>

                </form>

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
