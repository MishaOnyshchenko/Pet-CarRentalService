<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/tag/helloNameTag.tld" prefix="custom" %>
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
</head>

<body>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form validate-form p-l-55 p-r-55 p-t-178">
                        <span class="login100-form-title">
                            <custom:helloNameTag/>
                        </span>

                        <div class="wrap-input100 validate-input m-b-16">
                            <form class="container-login100-form-btn" action="/show" method="get">
                                <button type="submit" class="login100-form-btn">
                                    Car hire
                                </button>
                            </form>
                        </div>



                        <div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
							Already have an account?
						</span>

                            <a href="/login" class="txt3">
                                Sign in
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form validate-form p-l-55 p-r-55 p-t-178">
                        <c:if test="${not empty sessionScope.user}">
                            <c:set var="user" value="${sessionScope.user}"/>
                        </c:if>
                        <span class="login100-form-title">
                            <custom:helloNameTag name="${user.name}"/>
                        </span>
                        <div class="wrap-input100 validate-input m-b-16">
                            <form class="container-login100-form-btn" action="/show" method="get">
                                <button type="submit" class="login100-form-btn">
                                    Hire car
                                </button>
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

                        <div class="wrap-input100 validate-input m-b-16">
                            <div class="row">
                                <div class="col-6">
                                    <h3>name:</h3>
                                </div>
                                <div class="col-6">
                                    <h3>${user.name}</h3>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <h3>email:</h3>
                                </div>
                                <div class="col-6">
                                    <h3>${user.email}</h3>
                                </div>
                            </div>
                        </div>
                        <div>
                            <a href="/logout" class="txt3">
                                Sign out
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>

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
