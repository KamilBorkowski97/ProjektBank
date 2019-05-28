<%-- 
    Document   : loan
    Created on : 2019-05-24, 23:00:46
    Author     : adria
--%>

<%@page import="ObjectFactory.UserBean"%>
<%@page import="ObjectFactory.Loan"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<jsp:include page="headerlogged.jsp" />

            <div class="row">
            <div class="col">
                     <jsp:include page="menu.jsp" />
              </div>
              <div class="col-9">
                  <a name="kantor"></a>
        
        <form action="BuyCurrencyServlet">
                        
                    <%UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
                     Twoje saldo PLN: <%=currentUser.getAccountBean().getAccountBalance()%>
             
                          USD:<%=String.format("%.2f", currentUser.getKantor().getUsdBalance())%>
                          EUR:<%=String.format("%.2f", currentUser.getKantor().getEuroBalance())%>
                          GBP:<%=String.format("%.2f", currentUser.getKantor().getGbpBalance())%>
                          </br></br>
                          
                          Aktualne kursy kupna:</br>
                          USD<input type="number" name="usd" value="4.0" readonly /></br>
                                        GBP<input type="number" name="gbp" value="5.05" readonly/></br>
                                        EUR<input type="number" name="eur" value="4.45" readonly/>
                      </br>
               
                                 <div class="form-row">
                      <div class="col">
                           Wybierz którą walutę chcesz zakupić: USD<input type="radio" name="grupa1" value="USD" checked="checked" />
                                        GBP<input type="radio" name="grupa1" value="GBP" />
                                        EUR<input type="radio" name="grupa1" value="EUR" />
                           
                      </div>
                    </div>

                    <div class="form-row">
                            <div class="form-row">
                                
                             Wprowadź kwotę za którą chcesz kupić walutę:<input type="number" name="kantorKwota"/>zł</br>

                            </div>
                          </div>
                       <div class="form-row">
                            <div class="form-row">
                                    <input class="btnRegister" type="submit" value="Kup" />
                            </div>
                          </div>
            
 
        
                    </br></br>
                          
        </form>
                 
                          
        <form action="SellCurrencyServlet">
            
            
                                Aktualne kursy sprzedaży:</br>
                          USD<input type="number" name="usds" value="3.88" readonly /></br>
                                        GBP<input type="number" name="gbps" value="4.85" readonly/></br>
                                        EUR<input type="number" name="eurs" value="4.15" readonly/>
                      </br>
               
                                 <div class="form-row">
                      <div class="col">
                           Wybierz którą walutę chcesz sprzedać: USD<input type="radio" name="grupa2" value="USD" checked="checked" />
                                        GBP<input type="radio" name="grupa2" value="GBP" />
                                        EUR<input type="radio" name="grupa2" value="EUR" />
                           
                      </div>
                    </div>
            
                    <div class="form-row">
                            <div class="form-row">                                
                                Wprowadź kwotę którą chcesz sprzedać:<input type="number" name="kantorKwota2"/>zł</br>
                            </div>
                          </div>
                    <div class="form-row">
                            <div class="form-row">

                             <input class="btnRegister" type="submit" value="Sprzedaj" />
        
                            </div>
                          </div> 
                                          </form>

              </div>
        
    
<jsp:include page="footer.jsp" />