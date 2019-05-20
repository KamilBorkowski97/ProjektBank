package servlety;

import ObjectFactory.UserBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import networkOperations.DeleteUser;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session=request.getSession(false);  
        if(session!=null){  

            String userAccToDelete = request.getParameter("deleteAccount");
            
            if(!userAccToDelete.equals(""))
                DeleteUser.deleteUser(userAccToDelete);
            else
                
            
            request.getRequestDispatcher("adminPage.jsp").include(request, response);
            
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