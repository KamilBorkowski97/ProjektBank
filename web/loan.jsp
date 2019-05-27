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
        
        <form action="LoanServlet">
            
                     <div class="form-row">
                      <div class="col">
                       Kwota pożyczki <input type="number" name="amount" min="1" max="1000000" />
                      </div>
                    </div>
            
                    <div class="form-row">
                            <div class="form-row">
                                
                             Wybierz okres kredytu:<input type="number" name="loanPeroid" min="1" max="20"/>lat
                            </div>
                          </div>
            
        <input class="btnRegister" type="submit" value="sprawdź ofertę" />
        
        </form>
                  
              </div>

        
    
<jsp:include page="footer.jsp" />