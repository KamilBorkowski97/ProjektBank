package servlety;

import ObjectFactory.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import networkOperations.Investment;

public class InvestmentConfirmServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession session = request.getSession(false);
        response.setCharacterEncoding("UTF-8");
        
        if(session!=null){
            
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
            int kwota = (int) session.getAttribute("kwota");
            int procent = (int) session.getAttribute("procent");
            Investment.addMoney(user, kwota, procent);
            response.sendRedirect("ProfileServlet");
            
        }
        else{
            response.sendRedirect("invalidLogin.jsp"); //error page 
        }

        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
