package servlety;

import ObjectFactory.UserBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import networkOperations.Transaction;

public class TransactionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html");  
            response.setCharacterEncoding("UTF-8");
        
            HttpSession session=request.getSession(false);  
        if(session!=null){  
          
            try{
                String title = request.getParameter("title");
                String accNumber = request.getParameter("accNumber");
                int amount = Integer.parseInt(request.getParameter("amount"));

                if(title.equals("") || accNumber.equals("") || amount<=0 ) {
                    response.sendRedirect("transaction.jsp");
                }
                
                UserBean user = (UserBean) session.getAttribute("currentSessionUser");
                boolean isPossible = Transaction.transfer(title,accNumber,amount, user);
                if(isPossible)
                    request.getRequestDispatcher("transactionSuccess.jsp").include(request, response);  
                else
                    request.getRequestDispatcher("Error.jsp").include(request, response);
                  
            }catch(IOException | NumberFormatException | ServletException e){
                    response.sendRedirect("transaction.jsp");
                    }
            }
        else{  
             request.getRequestDispatcher("invalidLogin.jsp").include(request, response);  
            }  
    }
}