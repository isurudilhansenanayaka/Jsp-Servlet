/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.User;

/**
 *
 * @author isuru_s
 */
public class welcome {
    static Connection conn=null;
    public static  List<User> listAllUsers() throws SQLException {
        List<User> AllUsers = new ArrayList<>();
         
        String sql = "SELECT * FROM user";
         
        try {
            conn=DBconnection.getConnection();
            Statement st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("userName");
                String email = rs.getString("email"); 
            User user = new User(id, userName, email);
            AllUsers.add(user);
            
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return AllUsers;
    }
    
    public static int getNumberOfRows(){
        int result = 0;
        String query = "SELECT COUNT(*) FROM user";
        ResultSet rs = null;
        
        try{
            
            conn = DBconnection.getConnection();
            rs = conn.prepareStatement(query).executeQuery();
            
            if(rs.next()){
                result = rs.getInt("count(*)");
            }
            
            System.out.println("result"+result);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
                        
            if(rs != null){
                try{
                    rs.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
        return result;
    }
    public static List<User> getUsers(int currentPageNumber,int numberOfRows){
       ResultSet rs = null;
       PreparedStatement ps = null;
       List <User> users = new LinkedList<>();
       String query = "SELECT * FROM user ORDER BY id LIMIT ?,?";
       int start = currentPageNumber * numberOfRows - numberOfRows;//get the starting index by this calculation
         
       try{
           conn = DBconnection.getConnection();
           ps = conn.prepareStatement(query);
           ps.setInt(1, start);
           ps.setInt(2, numberOfRows);
           rs = ps.executeQuery();
           
           while(rs.next()){
               User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
               users.add(u); 
               System.out.println(rs.getString(3));
           } 
           System.out.println("numberOfRows    "+numberOfRows); 
       }catch(Exception e){
           System.out.println(e);
       }finally{
           if(conn != null){
               try{
                   conn.close();
               }catch(Exception e){
                   System.out.println(e);
               }
           }
           if(rs != null){
               try{
                   rs.close();
               }catch(Exception e){
                   System.out.println(e);
               }
           }
       }
       return users;
    }
    public List<User> getPdfdata(){
       
        ResultSet rs = null;
        PreparedStatement ps = null;
        List <User> users = new LinkedList<>();
        String query = "SELECT * FROM user";
       
        try{
           conn = DBconnection.getConnection();
           ps = conn.prepareStatement(query);  
           rs = ps.executeQuery();
           
           while(rs.next()){
               int id = rs.getInt("id");
                String userName = rs.getString("userName");
                String email = rs.getString("email"); 
               User u1 = new User(id,userName,email);
               users.add(u1); 
           } 
        }catch(Exception e){
            System.out.println(e);
        }finally{
           if(conn != null){
               try{
                   conn.close();
               }catch(Exception e){
                   System.out.println(e);
               }
           }
           if(rs != null){
               try{
                   rs.close();
               }catch(Exception e){
                   System.out.println(e);
               }
           }
           if(ps != null){
               try{
                   ps.close();
               }catch(Exception e){
                   System.out.println(e);
               }
           }           
        }
        return users;
    }
//    public User getUser(int id) throws SQLException {
//        User user = null;
//        String sql = "SELECT * FROM user WHERE id = ?";
//         
//        try {
//            conn=DBconnection.getConnection();
//            PreparedStatement st = conn.prepareStatement(sql);
//            
//        st.setInt(1, id);
//        ResultSet rs=st.executeQuery();
//        if (rs.next()) {
//           
//            String userName = rs.getString("userName");
//            String email = rs.getString("email");
//             
//            user = new User(id, userName, email);
//        }
//         
//        rs.close();
//        st.close();
//         
//        
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//        
//         
//        
//         
//        return user;
//    }
}
