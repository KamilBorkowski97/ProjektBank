<%@ page language="java" contentType="text/html; charset=UTF-8" session="false"
    pageEncoding="UTF-8"%>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/validate.js"></script>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
        <title>FakeBank</title>
       
    </head>
    <body>
        

        <div class="container-fluid header">
            <div class="container" style="margin-top: 50px;">
                <header class="clearfix">
                    <div class="logo float-left">
                        <a href="main.jsp"><img src="img/logo.png"/></a>
                    </div>
                    <div class="box-input float-right">
                        <a class="btnLogin" href="login.jsp">Logowanie</a>
                        <a class="btnRegister" href="register.jsp">Rejestracja</a>
                    </div>
                </header>
                
                <h1 style="background: #fff; width: 40%;">Witaj w naszym banku</h1>
                <p style="background: #fff; width: 43%;"><a class="block_reg" href="register.jsp">Zarejestruj sie</a> i sprawdz jak dziala nasz bank internetowy.</p>
                <p style="background: #fff; width: 40%;">Przetestuj funkcje, ktore <a class="block_reg" href="login.jsp">dostepne sa po zalogowaniu</a> !</p>
            </div>
        </div>
        
        <div class="container main">
        