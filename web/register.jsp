
        
      <jsp:include page="header.jsp" />
           

      
         
              
             <form method="get" action="register" >
                    <div class="form-row">
                      <div class="col">
                        <input type="text" name="name" class="form-control" placeholder="Imie...">
                      </div>
                      <div class="col">
                        <input type="text" name="lastName" class="form-control" placeholder="Nazwisko...">
                      </div>
                    </div>
                  
                    <div class="form-row">
                      <div class="col">
                        <input type="text" name="email" class="form-control" placeholder="Adres email...">
                      </div>
                      <div class="col">
                          <input type="text" name="phone" class="form-control" placeholder="Numer telefonu">
                      </div>
                    </div>
                  
                    <div class="form-row">
                        <div class="col-4">
                          <input type="text" name="city" class="form-control" placeholder="Miasto">
                        </div>
                        <div class="col">
                            <input type="text" name="addres" class="form-control" placeholder="Ulica, nr domu">
                        </div>
                        <div class="col">
                          <input type="text" name="postalCode" class="form-control" placeholder="Kod pocztowy">
                        </div>
                    </div>
                  
                     <div class="form-row">
                      <div class="col">
                        <input type="text" name="password" class="form-control" placeholder="Wprowadz swoje haslo...">
                      </div>
                    </div>
                 <input type="submit" value="submit" class="btnRegister">
              </form>
          
                
           
        
         
        
         
         
        
        
     <jsp:include page="footer.jsp" />