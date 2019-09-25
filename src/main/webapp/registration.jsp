<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <title>Register</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="libs/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="libs/css/util.css">
    <link rel="stylesheet" type="text/css" href="libs/css/main.css">
</head>

<body>
<div>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">

                <form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="/register" method="post">
                            <span class="login100-form-title">
                                Registration
                            </span>
                    <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter name">
                        <input name="name" type="text" class="input100" id="inputName"
                               placeholder="Name">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter surname">
                        <input name="surname" type="text" class="input100" id="inputSurname"
                               placeholder="Surname">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter age">
                        <input name="age" type="number" class="input100" id="inputAge"
                               placeholder="Age">
                        <span class="focus-input100"></span>
                    </div>

                    <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter email">
                        <input name="email" type="email" class="input100" id="exampleInputEmail1"
                               placeholder="Email">
                        <span class="focus-input100"></span>
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Please enter password">
                        <input name="password" type="password" class="input100" id="exampleInputPassword1"
                               placeholder="Password">
                        <span class="focus-input100"></span>
                    </div>
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
                            Register
                        </button>
                    </div>

                    <div class="flex-col-c p-t-170 p-b-40">
                            <span class="txt1 p-b-9">
                                Already have an account?
                            </span>
                        <a href="login.jsp" class="txt3">
                            Sign in
                        </a>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>