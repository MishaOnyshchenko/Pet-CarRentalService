<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCar</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">

            <form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="/add" method="post">
					<span class="login100-form-title">
						Add car
					</span>

                <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter car brand">
                    <input class="input100" type="text" name="brand" placeholder="Brand">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter name">
                    <input class="input100" type="text" name="name" placeholder="Name">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter category">
                    <input class="input100" type="text" name="category" placeholder="Category">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter price">
                    <input class="input100" type="text" name="price" placeholder="Price/day">
                    <span class="focus-input100"></span>
                </div>


                <div class="text-right p-t-13 p-b-23">
						<span class="txt1">
							Go to
						</span>

                    <a href="/index.jsp" class="txt2">
                        main menu
                    </a>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        add
                    </button>
                </div>

                <div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
							<%--Does not have sense yet.--%>
						</span>

                    <a href="/logout" class="txt3">
                        Sign out
                    </a>
                </div>
            </form>
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
