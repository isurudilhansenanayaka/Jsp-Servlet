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

/**
 *
 * @author isuru_s
 */
public class Controller extends HttpServlet {
    Connection conn=null;
        Statement st=null;
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
        private void db() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/userjsp","root","");
            st=(Statement) conn.createStatement();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            
//            String _userName=request.getParameter("userName");
//            String _password=request.getParameter("password");
//            String sql = "SELECT password FROM user WHERE userName = 'isuru'";
//      ResultSet rs = st.executeQuery(sql);
//      //STEP 5: Extract data from result set
//      while(rs.next()){
//         //Retrieve by column name
//         String id  = rs.getString("password");
//         
//
//         //Display values
//         System.out.print("ID: " + id);
//         
//      }
////            try{
////                if(_userName!=null){
////                    if(_userName.equals("abc@gmail.com") && _password.equals("123")){
////                        response.sendRedirect("welcome.jsp");
////                    }
////                    else{
////                     out.println("Login Failed  ");
////                }
////                }
////                
////            }
////            catch(Exception ex){
////                out.println("Error :"+ex.getMessage());
////            }
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
        try {
            this.db();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        String _userName=request.getParameter("userName");
            String _password=request.getParameter("password");
            String sql = "SELECT password FROM user WHERE userName = '"+_userName+"'";
      
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String id  = rs.getString("password");
                
                
                //Display values
                System.out.print("ID: " + id);
                if(id.equals(_password)){
                     HttpSession session = request.getSession(true);
                     session.setAttribute("username1",_userName );
                     
                    response.sendRedirect("welcome.jsp");
                 
                }
                else{
                   response.sendRedirect("index.jsp"); 
                }
                        }   } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    

}
}
