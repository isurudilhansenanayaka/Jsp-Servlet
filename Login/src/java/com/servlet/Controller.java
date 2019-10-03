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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.hash;
import com.servlet.DBconnection;
import static com.servlet.DBconnection.getConnection;

/**
 *
 * @author isuru_s
 */
public class Controller extends HttpServlet {

    Connection conn = null;
    Statement st = null;
    ResultSet rs, rs1;
    HttpSession session;
    DBconnection c=null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    private void db() throws SQLException {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userjsp", "root", "");
//            st = (Statement) conn.createStatement();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            
            String _userName = request.getParameter("userName");
            String _password = request.getParameter("password");
            conn=(Connection) getConnection();
            String sql = "SELECT password FROM user WHERE userName = '" + _userName + "'";

            String hashpw = hash.encryptThisString(_password);
            st = (Statement) conn.createStatement();
            rs = st.executeQuery(sql);

            //STEP 5: Extract data from result set
            if (rs != null) {
                while (rs.next()) {
                    //Retrieve by column name
                    String id = rs.getString("password");

                    //Display values
                    System.out.print("ID: " + id);
                    if (id.equals(hashpw)) {

                        session = request.getSession();
                        session.setMaxInactiveInterval(300);

                        session.setAttribute("username1", _userName);
                        
                        session.setAttribute("password1", _password);
                        response.sendRedirect("/Login/retrieve");

                    } else {
                        out.print("Sorry, username or password error!");
                        response.sendRedirect("index.jsp");

                    }
                }
            } else {
                out.print("Sorry, username or password error!");
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
