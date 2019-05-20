package servlety;

import networkOperations.Logowanie;
import ObjectFactory.UserBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setCharacterEncoding("UTF-8");
        
        try{	    
            UserBean user = new UserBean();
            user.setLogin(request.getParameter("login"));
            user.setPassword(request.getParameter("password"));
            user = Logowanie.login(user);
        if (user.isValid()){
            session = request.getSession(true);
            session.setAttribute("currentSessionUser",user); 
            
            if(user.isIsAdmin())
                response.sendRedirect("AdminServlet");
            else
                response.sendRedirect("ProfileServlet"); //logged-in page      		
        }

        else 
            response.sendRedirect("invalidLogin.jsp"); //error page 
        
    }		
    catch (IOException theException) 	    
        {
            System.out.println(theException.getMessage()); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }
}