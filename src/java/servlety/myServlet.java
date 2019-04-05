package servlety;

import networkOperations.Logowanie;
import ObjectFactory.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class myServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bank beta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bank beta</h1>");
            out.println("<h1>request method: " + request.getMethod() + "</h1>");
            //out.println("<h1>myServlet " + request.getParameterMap() + "</h1>");
            out.println("<ul>");
            
            for(String name: request.getParameterMap().keySet()){
                out.println("<li>" + name + "</li>");
            }
            
            out.println("</ul>");
            
            HttpSession session = request.getSession();
            session.setAttribute("Liczba", request.getParameter("liczba"));
            out.println("<p>"+session.getId()+"</p>");
            out.println("<p>"+session.getAttribute("Liczba")+"</p>");
            
            response.addCookie(new Cookie("imie","kamil"));
            
            Cookie[] cookies = request.getCookies();
            
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getValue().equals("kamil")) {
                      out.println("<p> czesc " + cookie.getValue());
                    }
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        try{	    

        UserBean user = new UserBean();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user = Logowanie.login(user);
        if (user.isValid()){
            HttpSession session = request.getSession(true);	    
            session.setAttribute("currentSessionUser",user); 
            response.sendRedirect("userLogged.jsp"); //logged-in page      		
        }

        else 
            response.sendRedirect("invalidLogin.jsp"); //error page 
        
    }		
    catch (IOException theException) 	    
        {
            System.out.println(theException); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}