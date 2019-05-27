<%-- 
    Document   : loan
    Created on : 2019-05-24, 23:00:46
    Author     : adria
--%>

<%@page import="ObjectFactory.Loan"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<jsp:include page="headerlogged.jsp" />

            <div class="row">
            <div class="col">
                     <jsp:include page="menu.jsp" />
              </div>
              <div class="col-9">
            <form action="LoanAcceptServlet">
                     <%Loan loan = (Loan) (session.getAttribute("currentSessionLoan"));%>
                             
                             Warunki Pożyczki</br></br>
                       
                        Kwota pożyczki: <%= loan.getAmount()%>zł</br></br>
                        
                        Oprocentowanie: <%=loan.getInterest()%>%</br></br>
                        
                        Miesięczna rata: <%=loan.installment()%>zł</br></br>
                        
                        Łączna kwota pożyczki: <%=loan.fullcost()%>zł</br></br>
                        
            
        <input class="btnRegister" type="submit" value="Akceptuje warunki" />
            </form>
      
              </div>

        
    
<jsp:include page="footer.jsp" />