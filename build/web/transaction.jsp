<%-- 
    Document   : transaction
    Created on : 2019-04-20, 18:00:39
    Author     : Kamil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction</title>
    </head>
    <body>
        <h1>Wykonaj przelew:</h1>
        
        <form action="TransactionServlet">
            
        Title <input type="text" name="title" value="" />
        Account number <input type="text" name="accNumber" value="" />
        Amount <input type="text" name="amount" value="" />
        <input type="submit" value="submit" />
        <input type="reset" value="Reset" />
        
        </form>
    </body>
</html>
