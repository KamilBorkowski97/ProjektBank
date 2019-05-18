package servlety;

import ObjectFactory.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InvestmentServlet extends HttpServlet {

    private int time=10;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        response.setCharacterEncoding("UTF-8");
        
        if(session!=null){
            int kwota;
            int procent;
            try{
                kwota = Integer.parseInt(request.getParameter("kwota"));
                procent = Integer.parseInt(request.getParameter("grupa"));
                UserBean user = (UserBean) session.getAttribute("currentSessionUser");
            
            if(kwota>user.getAccountBean().getAccountBalance()){
                System.out.println("Nie masz tyle kasy biedaku");
                response.sendRedirect("ProfileServlet");
            }
            else{
                if(time<=0){
                    session.setAttribute("kwota", kwota);
                    session.setAttribute("procent", procent);
                    time = 10;
                    request.getRequestDispatcher("ConfirmInvestment.jsp").include(request, response); 
                }
                else{
                    //zrób arek w css żeby znikał form po kliknięciu buttona ?
                
                response.setIntHeader("Refresh", 1);
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
                 out.println(docType +
                    "<html>\n" +
                    "<head></head>\n"+
                    "<body>\n" +
                    "<p>Pieniazki beda na Twoim koncie za: " + (time--) + "</p>\n"
                 );
                 
                 //request.getRequestDispatcher("userLogged.jsp").include(request, response); 
                 
                }
            }
            }catch(IOException | NumberFormatException | ServletException e){
                kwota=0;
                response.sendRedirect("ProfileServlet");
            }

        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}