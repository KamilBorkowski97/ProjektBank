/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlety;

import ObjectFactory.Kantor;
import ObjectFactory.Loan;
import ObjectFactory.UserBean;
import car.exception.AppException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import networkOperations.BuyCurrency;

/**
 *
 * @author adria
 */
public class BuyCurrencyServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try{
             HttpSession session=request.getSession(true);
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
            
            int amount = 0;
            String kwotaKantor = request.getParameter("kantorKwota");
            if(kwotaKantor == null || kwotaKantor.matches("\\D") || kwotaKantor.equals("")){
                response.sendRedirect("fail.jsp");
            }else{
            
            amount= Integer.parseInt(request.getParameter("kantorKwota"));
            
            user.getKantor().setUsd(Double.parseDouble(request.getParameter("usd")));
            user.getKantor().setEur(Double.parseDouble(request.getParameter("eur")));
            user.getKantor().setGbp(Double.parseDouble(request.getParameter("gbp")));
            
            String type = request.getParameter("grupa1");
            
            if(user.getAccountBean().getAccountBalance() > amount){
            
              user.getKantor().setAmount(amount);
              BuyCurrency.buyCurrency(user, type);
              response.sendRedirect("succesKantor.jsp");
              
            }else{
            response.sendRedirect("failSell.jsp");
            }
            }

            
            
        
        
        }catch(IOException theException){
            System.out.println(theException.getMessage()); 
        }
 
                  //request.getRequestDispatcher("main.jsp").forward(request,response);
    
           
             

      }


}
