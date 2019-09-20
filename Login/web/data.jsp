<%-- 
    Document   : data
    Created on : Sep 10, 2019, 5:04:08 PM
    Author     : isuru_s
--%>

<%@page import="com.servlet.connection"%>
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
        String passwordc=request.getParameter("passwordc");
        Connection conn=null;
        
        Statement st=null;
        
        try{
            conn=connection.db();
            st=conn.createStatement();
                if(!passwordc.equals(password)){
                request.setAttribute("msg","Passwords mismatched");
//                out.print("https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js");
//                 out.print("http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js");
//                 out.print("<script>");
//                 out.print("$(document).ready.(function(){");
//                 out.print("Swal.fire({type: 'error',title: 'Oops...',text: 'Something went wrong!',footer: '<a href>Why do I have this issue?</a>})");
//                 out.print("});");
//                 out.print("</script>");
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
        %>
    </body>
</html>
