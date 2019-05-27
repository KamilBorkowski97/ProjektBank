/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlety;

import ObjectFactory.AccountBean;
import ObjectFactory.Address;
import ObjectFactory.Loan;
import ObjectFactory.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import networkOperations.Rejestracja;

/**
 *
 * @author adria
 */
public class LoanServlet extends HttpServlet {
    
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try{
            
            String amount = request.getParameter("amount");
            String loanPeroid = request.getParameter("loanPeroid");
            
            if(amount.equals("") || amount == null || amount.matches("\\D")){
                response.sendRedirect("failLoan.jsp");
            }else{
            
                    Loan loan = new Loan(Integer.parseInt(amount),Integer.parseInt(loanPeroid));
                    session = request.getSession(true);
                    session.setAttribute("currentSessionLoan",loan); 
        
                    response.sendRedirect("loanAccept.jsp");
            }

        }catch(IOException theException){
            System.out.println(theException.getMessage()); 
        }
 
                  //request.getRequestDispatcher("main.jsp").forward(request,response);
    
           
             

      }
    
}
