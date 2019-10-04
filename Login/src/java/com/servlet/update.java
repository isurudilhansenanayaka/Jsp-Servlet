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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.User;
import service.hash;

/**
 *
 * @author isuru_s
 */
public class update extends HttpServlet {
     Connection conn = null;
    Statement st = null;
    ResultSet rs;
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
        throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
//        User user=new User();
//        Integer id=user.getId();
//        String userName = user.getUserName();
//    String email= user.getEmail();
//    String password = user.getPassword();
   
     
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
         try {
             processRequest(request, response);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
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
//         try {
//             processRequest(request, response);
//         } catch (ClassNotFoundException ex) {
//             Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         try {
//             conn=(Connection) DBconnection.getConnection();
//             String _userName = request.getParameter("userName");
//            String sql = "SELECT * FROM user";
//            rs=st.executeQuery(sql);
//         } catch (ClassNotFoundException ex) {
//             Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (SQLException ex) {
//             Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
//         }
             Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
         try {
             conn=(Connection) DBconnection.getConnection();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
         }
////    User user=new User();
//        String userName = user.getUserName();
//    String email= user.getEmail();
//    String password = user.getPassword();
//    try{
//    st=(Statement) conn.createStatement();
//    String sql ="SELECT * FROM user WHERE userName=userName";
//    
//    rs = st.executeQuery(sql);
//    
//    
//while(rs.next()){
//    conn.close();
//}
//} catch (Exception e) {
//e.printStackTrace();
//}
 RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
  dispatcher.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
