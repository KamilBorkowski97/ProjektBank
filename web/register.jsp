<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
        
      <jsp:include page="header.jsp" />
           

      
         
              
             <form method="get" action="register" >
                    <div class="form-row">
                      <div class="col">
                        <label for="field-name">Imię*</label>
                        <input type="text" name="name" class="form-control" placeholder="Jan..." required pattern="^[a-zA-Ząćęłńóśżź]{3,15}$">
                      </div>
                      <div class="col">
                        <label for="field-name">Nazwisko*</label>  
                        <input type="text" name="lastName" id="formName" class="form-control" placeholder="Kowalski..." required pattern="^[a-zA-Ząćęłńóśżź]{3,15}$">
                      </div>
                    </div>
                  
                    <div class="form-row">
                      <div class="col">
                        <label for="field-name">Adres email*</label>
                        <input type="email" id="formEmail" name="email" class="form-control" placeholder="example@xx.pl" required >
                      </div>
                      <div class="col">
                          <label for="field-name">Numer telefonu*</label>
                          <input type="text" name="phone" class="form-control" placeholder="xxx xxx xxx" pattern="[0-9]{3} [0-9]{3} [0-9]{3}" required maxlength="11">
                      </div>
                    </div>
                  
                    <div class="form-row">
                        <div class="col-4">
                          <label for="field-name">Miasto*</label>
                          <input type="text" name="city" class="form-control" placeholder="Miasto" required pattern="^[a-zA-Ząćęłńóśżź]{3,15}$">
                        </div>
                        <div class="col">
                            <label for="field-name">Ulica, nr domu*</label>
                            <input type="text" name="addres" class="form-control" placeholder="Ulica, nr domu" required>
                        </div>
                        <div class="col">
                          <label for="field-name">Kod pocztowy*</label>
                          <input type="text" name="postalCode" class="form-control" placeholder="Kod pocztowy" required pattern="[0-9]{2}\-[0-9]{3}">
                        </div>
                    </div>
                  
                     <div class="form-row">
                      <div class="col">
                        <input type="password" name="password" class="form-control" placeholder="Wprowadz swoje haslo..." required >
                      </div>
                    </div>
                 <input type="submit" value="submit" class="btnRegister">
              </form>
          
                
           
        
         
        
         
         
        
        
     <jsp:include page="footer.jsp" />