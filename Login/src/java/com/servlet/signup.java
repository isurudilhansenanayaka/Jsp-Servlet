/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.hash;

/**
 *
 * @author isuru_s
 */
@WebServlet(name = "signup", urlPatterns = {"/signup"})
public class signup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String userName=request.getParameter("userName");
       
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String passwordc=request.getParameter("passwordc");
        Connection conn=null;
        
        Statement st=null;
        
        try{
            conn=DBconnection.getConnection();
            st=(Statement) conn.createStatement();
                if(!passwordc.equals(password)){
                   request.setAttribute("msg","Passwords mismatched");
                   RequestDispatcher rd = request.getRequestDispatcher("signup.jsp"); //return the jsp
                   rd.forward(request, response);
                }else{
                String hashpw=hash.encryptThisString(password);
                String qry="INSERT INTO `user` (`userName`, `email`, `password`) VALUES ('"+userName+"', '"+email+"', '"+hashpw+"')";
                st.executeUpdate(qry);
                out.print("Success Regitration");
                response.sendRedirect("index.jsp");
                    }
        }
            
        catch(Exception ex){
            out.print(ex.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
