<%-- 
    Document   : nwelcome
    Created on : Sep 10, 2019, 1:54:49 PM
    Author     : isuru_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
         <form class="form" role="form" action="index.jsp"  method="POST">
             <button colspan="2" align="right" type="submit" class="btn btn-success" >Logout</button>
    
  
            </form>
        <td>Username: </td>
      <%
	    if(session.getAttribute("username1")== null){
                response.sendRedirect("index.jsp");
            }
           
		
	%>
       <%= session.getAttribute("username1") %>" 
        <h1 class="text-success">Hello! Successful Login!</h1>
    </body>
</html>
