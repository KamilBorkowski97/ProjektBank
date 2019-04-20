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

        HttpSession session=request.getSession(false);  
        if(session!=null){  
          
        
        String title = request.getParameter("title");
        String accNumber = request.getParameter("accNumber");
        int amount = Integer.parseInt(request.getParameter("amount"));
        
        Transaction.transfer(title,accNumber,amount);

        request.getRequestDispatcher("transactionSuccess.jsp").include(request, response);  
        
        }  
        else{  
            request.getRequestDispatcher("invalidLogin.jsp").include(request, response);  
        }  
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}