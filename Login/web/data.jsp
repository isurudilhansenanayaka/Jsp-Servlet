<%-- 
    Document   : data
    Created on : Sep 10, 2019, 5:04:08 PM
    Author     : isuru_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>data Page</title>
    </head>
    <body>
        <% 
        String firstName=request.getParameter("t1");
        String lastName=request.getParameter("t2");
        
        Connection conn=null;
        Statement st=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/userjsp","root","");
            st=conn.createStatement();
            String qry="INSERT INTO `user`(`firstName`,`lastName` `password`) VALUES ('"+firstName+"','"+lastName+"')";
            st.executeUpdate(qry);
            out.print("Success Regitration");
        }
            
        catch(Exception ex){
            out.print(ex.getMessage());
        }
        %>
    </body>
</html>
