/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.servlet.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author isuru_s
 */
public class UserDao {
    
     public static int update(User e){  
        int status=0;  
        try{  
            Connection conn=DBconnection.getConnection();  
            PreparedStatement ps=conn.prepareStatement(  
                         "update user set name=?,email=?,password=? where id=?");  
            ps.setString(1,e.getUserName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getPassword());  
             
            ps.setInt(4,e.getId());  
              
            status=ps.executeUpdate();  
              
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
     
//     public static User getEmployeeById(int id){  
//        User e=new User();  
//          
//        try{  
//            Connection conn=DBconnection.getConnection();  
//            PreparedStatement ps=conn.prepareStatement("select * from user where id=?");  
//            ps.setInt(1,id);  
//            ResultSet rs=ps.executeQuery();  
//            if(rs.next()){  
//                e.setId(rs.getInt(1));  
//                e.setUserName(rs.getString(2));  
//                e.setEmail(rs.getString(3)); 
//                e.setPassword(rs.getString(4));  
//                 
//                  
//            }  
//            conn.close();  
//        }catch(Exception ex){ex.printStackTrace();}  
//          
//        return e;  
//    }
     
}
