/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author isuru_s
 */
@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class logout extends HttpServlet {
    HttpSession session;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println("rygthytfuhyfujy");
            PrintWriter out = response.getWriter();
            
                         session = request.getSession();
                    
            session.invalidate();  
             
            
            response.sendRedirect("index.jsp");
//                PrintWriter out = response.getWriter();
//		out.println("thanq you!!, Your session was destroyed successfully!!");
//		session = request.getSession(false);
//                
//		// session.setAttribute("user", null);
//		session.removeAttribute("userr");
//		//session.getMaxInactiveInterval();
//                response.sendRedirect("index.jsp");
    }

    
 

}
 