/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isuru_s
 */
public class DBconnection {
    public static Connection getConnection() throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn;
        try {
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userjsp", "root", "");
            Statement st = (Statement) conn.createStatement();
            return conn;
            
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
