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
        
        <form>
            
                     <div class="form-row">
                      <div class="col">
                       Wprowadziłeś błędny format danych w polu "kwota pożyczki".</br>
                       </br>
                       <a href="loan.jsp"> spróbuj jeszcze raz </a>:)
                       
                      </div>
                    </div>
        
        </form>
                  
              </div>

        
    
<jsp:include page="footer.jsp" />

