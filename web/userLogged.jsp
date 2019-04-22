<%@page import="servlety.myServlet"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
            import="ObjectFactory.UserBean" 
   %>
 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

   <html>

      <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>   User Logged Successfully   </title>
      </head>
	
      <body>

         <center>
             
             <%UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
             Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName()%>
             
             <form name="wyloguj" action="LogoutServlet">
                 
                 <input type="submit" value="logout" name="logout" />
                 
             </form>
             
             <br/><br/><br/><hr>
             
             Twój nr konta to:  <%=currentUser.getAccountBean().getAccountNumber()%>
             
             Twoje saldo wynosi: <%=currentUser.getAccountBean().getAccountBalance()%>
             
             <br><br>
             
             <a href="transaction.jsp">Wykonaj przelew</a>
             
             <br>
             
             <h3>Pieniazki za darmo ? Skorzystaj z naszej lokaty:</h3>
             
             <form action="InvestmentServlet">
                 
                 <label>Ile procent ?</label>
                 10<input type="radio" name="grupa" value="10" checked="checked" />
                 20<input type="radio" name="grupa" value="20" />
                 50<input type="radio" name="grupa" value="50" />
                 
                 <br>
                 
                 <label>Jaka kwota ?</label>
                 
                 <input type="text" name="kwota" value="" />
                 
                 <br>
                 <input type="submit" value="submit" />
                 
             </form>
                    
         </center>

      </body>
	
   </html>