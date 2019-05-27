/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlety;

import ObjectFactory.UserBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static networkOperations.SellCurrency.sellCurrency;

/**
 *
 * @author adria
 */
public class SellCurrencyServlet extends HttpServlet {


    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try{
            HttpSession session=request.getSession(true);
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
            
            
            String kwotaKantor = request.getParameter("kantorKwota2");
            if(kwotaKantor == null || kwotaKantor.matches("\\D") || kwotaKantor.equals("")){
                response.sendRedirect("fail.jsp");
            }else{
            String type = request.getParameter("grupa2");
             int amount= Integer.parseInt(kwotaKantor);
             
            user.getKantor().setAmount(amount);
            user.getKantor().setUsd(Double.parseDouble(request.getParameter("usds")));
            user.getKantor().setEur(Double.parseDouble(request.getParameter("eurs")));
            user.getKantor().setGbp(Double.parseDouble(request.getParameter("gbps")));
            
            double usd= user.getKantor().getUsdBalance();
            double eur = user.getKantor().getEuroBalance();
            double gbp = user.getKantor().getGbpBalance();
            
            if(type.equals("USD")){
                if(usd < amount){
                    response.sendRedirect("failSell.jsp");
                }else{
                     if(sellCurrency(user,type)){
                         response.sendRedirect("succesKantor.jsp");
                     }
                }
            }else  if(type.equals("EUR")){
                if(eur < amount){
                    response.sendRedirect("failSell.jsp");
                }else{
                     if(sellCurrency(user,type)){
                         response.sendRedirect("succesKantor.jsp");
                     }
                }
            }else if(type.equals("GBP")){
                if(gbp < amount){
                    response.sendRedirect("failSell.jsp");
                }else{
                     if(sellCurrency(user,type)){
                         response.sendRedirect("succesKantor.jsp");
                     }
                }
            }
            }

            
            
        
        
        }catch(IOException theException){
            System.out.println(theException.getMessage()); 
        }
 
                  //request.getRequestDispatcher("main.jsp").forward(request,response);
    
           
             

      }


}
