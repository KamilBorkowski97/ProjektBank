<%-- 
    Document   : transaction
    Created on : 2019-04-20, 18:00:39
    Author     : Kamil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<jsp:include page="headerlogged.jsp" />

            <div class="row">
            <div class="col">
                     <jsp:include page="menu.jsp" />
              </div>
              <div class="col-9">
                  
                  <h1>Wykonaj przelew:</h1>
        
        <form action="TransactionServlet">
            
                     <div class="form-row">
                      <div class="col">
                       Tytuł <input type="text" name="title" value="" />
                      </div>
                    </div>
            
                    <div class="form-row">
                            <div class="col">
                              Numer konta <input type="text" name="accNumber" value="" />
                            </div>
                          </div>
            
                    <div class="form-row">
                            <div class="col">
                             Kwota <input type="text" name="amount" value="" />
                            </div>
                          </div>
            
        <input class="btnRegister" type="submit" value="submit" />
        <input class="btnLogin" type="reset" value="Reset" />
        
        </form>
                  
              </div>

        
    
<jsp:include page="footer.jsp" />