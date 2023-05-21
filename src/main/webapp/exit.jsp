<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Form</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: #000;
            padding-bottom: 100px;
        }
        .form{
            position: absolute;
      	    top: 50%;
      	    left: 50%;
      	    transform: translate(-50%,-50%);
      	    background: rgba(0,0,0,.7);
        }
        .form h1 {
            font: 300 60px 'Oswald', sans-serif;
    	    margin: 100px 100px;
    	    padding: 0;
    	    text-align: center;
    	    color: #fff;
    	    font-size: 30px;
    	    text-transform: uppercase;
        }
        .form a {
	        display: block;
	        margin-top: 20px;
	        padding: 0 0 0px;
	        text-align: center;
	        color: #fff;
	        text-decoration: none;
	        transition: .3s;
        }
        .form a:hover {
	        color: #0fc3f5;
        }
    </style>
</head>
<body>
    <main>
        <div class="form">
    		<h1>Вы вышли из аккаунта</h1>
    		<a href="./authorization" class="login">Войти</a>
    		<a href="./registration" class="login">Зарегистрироваться</a>
    	</div>
    </main>
</body>
</html>
