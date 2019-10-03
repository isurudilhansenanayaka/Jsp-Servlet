/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.User;

/**
 *
 * @author isuru_s
 */
public class retrieve extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    Connection conn = null;
    Statement st = null;
    ResultSet rs;
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet retrieve</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet retrieve at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            //processRequest(request, response);                    
            List<User>  AllUsers;
            int currentPageNumber,numberOfRows;
        
        
        try {
            if(request.getParameter("currentPageNumber") != null && request.getParameter("numberOfRows") != null){
            currentPageNumber = Integer.parseInt(request.getParameter("currentPageNumber"));
            numberOfRows = Integer.parseInt(request.getParameter("numberOfRows"));; 
        }else{
            currentPageNumber = 1;
            numberOfRows = 3;
            
        }
        int rows=welcome.getNumberOfRows();
        System.out.println("numberRows"+rows);
        int numberOfPages = (int) Math.ceil((double)rows / (double)numberOfRows);
        System.out.println("numberOfPages"+numberOfPages);
        System.out.println("currentPageNumber"+currentPageNumber);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPageNumber", currentPageNumber);
        request.setAttribute("numberOfRows", numberOfRows);
        request.setAttribute("AllUsers",welcome.getUsers(currentPageNumber, numberOfRows));
            AllUsers = welcome.listAllUsers();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(retrieve.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
        
        try {
            conn=(Connection) DBconnection.getConnection();
            String _userName = request.getParameter("userName");
            String sql = "SELECT * FROM user";
            rs=st.executeQuery(sql);
            while(rs.next()){
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(retrieve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(retrieve.class.getName()).log(Level.SEVERE, null, ex);
        }

            
    }
    private void AllUsers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> AllUsers = welcome.listAllUsers();
        request.setAttribute("AllUsers", AllUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
