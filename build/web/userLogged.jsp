<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
            import="ObjectFactory.UserBean"  import="servlety.LoginServlet"
   %>
 <jsp:include page="headerlogged.jsp" />
           
           
             
             <div class="row">
            <div class="col">
                     <jsp:include page="menu.jsp" />
              </div>
            <div class="col-9">
                
                 <%UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
             Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName()%>
              
                <form name="wyloguj" action="LogoutServlet">
                 
                 <input type="submit" value="logout" name="logout" />
                 
             </form>
             
             <br/><br/><br/><hr>
             Twój nr klienta to: <%=currentUser.getLogin()%>
             
             Twój nr konta to:  <%=currentUser.getAccountBean().getAccountNumber()%><br>
             
             Twoje salda  <br>
                          PLN:<%=currentUser.getAccountBean().getAccountBalance()%><br>
                          USD:<%=String.format("%.2f", currentUser.getKantor().getUsdBalance())%><br>
                          EUR:<%=String.format("%.2f", currentUser.getKantor().getEuroBalance())%><br>
                          GBP:<%=String.format("%.2f", currentUser.getKantor().getGbpBalance())%>
             
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
                
            </div>
             </div>
             
             
                    
       <jsp:include page="footer.jsp" />