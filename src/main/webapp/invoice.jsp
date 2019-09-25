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

    </style>
</head>

<body>

<div>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">

                <form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="/show" method="get">
                            <span class="login100-form-title">
                                Invoice
                            </span>

                    <c:set var="invoice" value="${invoice}"/>
                    <table>
                        <tr>
                            <td>Invoice #</td>
                            <td>${invoice.id}</td>
                        </tr>
                        <tr>
                            <td>Dated:</td>
                            <td>${invoice.date}</td>
                        </tr>
                        <tr>
                            <td>By order #</td>
                            <td>${invoice.orderId}</td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td>${invoice.description}</td>
                        </tr>
                        <tr>
                            <td>Total amount: $</td>
                            <td>${invoice.amount}</td>
                        </tr>
                    </table>


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

                    <div class="flex-col-c p-t-170 p-b-40">
                    <span class="txt1 p-b-9">
                        <%--Return home--%>
                    </span>
                        <a href="/logout" class="txt3">
                            Sign out
                        </a>
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

