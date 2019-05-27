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

                  Gratulujemy ! Kredyt został przyznany :) </br>
                  pieniądze znajdują się już na Twoim koncie :) </br>
                  
                  Przejdź do sekcji <a href="userLogged.jsp">DASHBOARD aby sprawdzić stan konta</a>
                  
                  
      
              </div>

        
    
<jsp:include page="footer.jsp" />