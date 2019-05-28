<%-- 
    Document   : adminPage
    Created on : 2019-05-20, 12:41:43
    Author     : Kamil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@page import="servlety.AdminServlet;"%>
<%@page import="ObjectFactory.Loan"%>


<jsp:include page="headerlogged.jsp" />
         <h3>Witaj w Panelu Admina Fake Banku</h3>
          
          <form name="wyloguj" action="LogoutServlet">
                 
                 <input type="submit" value="logout" name="logout" />
                 
             </form>
         <hr>
         
         <h3> Podaj nr konta który chcesz usunąć: </h3><br>
         
         <label></label>
         
         <form action="AdminServlet">
             <input type="text" name="deleteAccount" value="" />
             <input type="submit" value="Usuń" name="deleteButton" class="btnRegister"/>
         </form>
        
         

<jsp:include page="footer.jsp" />