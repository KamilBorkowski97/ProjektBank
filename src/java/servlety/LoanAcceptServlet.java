/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlety;

import ObjectFactory.Loan;
import ObjectFactory.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adria
 */
public class LoanAcceptServlet extends HttpServlet {
      

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try{
            HttpSession session=request.getSession(true); 
             UserBean u=(UserBean)session.getAttribute("currentSessionUser");  
             Loan loan = (Loan)session.getAttribute("currentSessionLoan");
             
             Loan.updateAccount(u, loan.getAmount());
             response.sendRedirect("loanMesseage.jsp"); 
      }catch(IOException e ){
             System.out.println(e.getMessage()); 
      }
    }


}

