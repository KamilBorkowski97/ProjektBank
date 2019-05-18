/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlety;

import ObjectFactory.AccountBean;
import ObjectFactory.Address;
import ObjectFactory.UserBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import networkOperations.Rejestracja;

/**
 *
 * @author adria
 */
public class registerServlet extends HttpServlet {
   
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
	
        String login;
        do{login = Rejestracja.rndLogin();
        }while(Rejestracja.loginValid(login));
        
        String accountNumber;
        do{accountNumber = Rejestracja.rndAccountNb();
        }while(Rejestracja.accountNumberValid(accountNumber));
        
        Address address = new Address("Poland",request.getParameter("city"),request.getParameter("addres"),request.getParameter("postalCode"));
        AccountBean account = new AccountBean(accountNumber,1000);
        
        UserBean user = new UserBean(
                             request.getParameter("password"),
                             login,request.getParameter("name"),
                             request.getParameter("lastName"),
                             request.getParameter("email"),
                             request.getParameter("phone"),
                             address,account);
        Rejestracja.registration(user);
        
     
             
               //   out.println("You are sucessfully registered");
                  request.getRequestDispatcher("main.jsp").forward(request,response);
    
           
             

      }
    
   
}
