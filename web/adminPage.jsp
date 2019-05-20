<%-- 
    Document   : adminPage
    Created on : 2019-05-20, 12:41:43
    Author     : Kamil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@page import="servlety.AdminServlet;"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
    <center>
         <h1>Witaj w Panelu Admina Fake Banku</h1>
         <hr>
         
         <h3> Podaj nr konta który chcesz usunąć: </h3><br>
         
         <label></label>
         
         <form action="AdminServlet">
             <input type="text" name="deleteAccount" value="" />
             <input type="submit" value="Usuń" name="deleteButton" />
         </form>
         
         
         
    </center>
    </body>
</html>
