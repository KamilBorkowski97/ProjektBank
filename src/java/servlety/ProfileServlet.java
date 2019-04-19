package servlety;

import ObjectFactory.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        //request.getRequestDispatcher("link.html").include(request, response);  
          
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        UserBean u=(UserBean)session.getAttribute("currentSessionUser");  
        String firstName = u.getFirstName();
        String lastName = u.getLastName();
          
        out.print("Hello, "+firstName+lastName+" Welcome to Profile");  
        request.getRequestDispatcher("userLogged.jsp").include(request, response); 
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("invalidLogin.jsp").include(request, response);  
        }  
        out.close();  
        
    }

}