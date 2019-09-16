<%-- 
    Document   : data
    Created on : Sep 10, 2019, 5:04:08 PM
    Author     : isuru_s
--%>

<%@page import="service.hash"%>
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
        String userName=request.getParameter("userName");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        Connection conn=null;
        
        Statement st=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/userjsp","root","");
            st=conn.createStatement();
            String hashpw=hash.encryptThisString(password);
            String qry="INSERT INTO `user` (`userName`, `email`, `password`) VALUES ('"+userName+"', '"+email+"', '"+hashpw+"')";
            st.executeUpdate(qry);
            out.print("Success Regitration");
            response.sendRedirect("welcome.jsp");
        }
            
        catch(Exception ex){
            out.print(ex.getMessage());
        }
        %>
    </body>
</html>
