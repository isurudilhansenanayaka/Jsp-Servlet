<%-- 
    Document   : nwelcome
    Created on : Sep 10, 2019, 1:54:49 PM
    Author     : isuru_s
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Welcome Page</title>
    </head>
    
         <form class="form" role="form" action="logout"  method="POST">
             
             <h1 class="text-success" align="right">Hello!  *<%= session.getAttribute("username1")  %>* Successful Login!</h1>
             <button colspan="2" align="right" type="submit" align="right" >Logout</button>
             
            </form>
             <button colspan="2" align="right" type="submit" align="right" ><a href="update.jsp"> Edit </a> </button>
      <%
	    if(session.getAttribute("username1")== null){
                  
                response.sendRedirect("index.jsp");
            }
           
		
	%>
        <h2 class="text-success"><td>Username: </td>
        <%= session.getAttribute("username1")  %>
        </h2 > 
       
       
        
    
<table  align="center" class="table table-bordered">
  <tr>
    <th>User id</th>
    <th>User Name</th>
    <th>Email</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  
      <% 
      try{
          Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userjsp", "root", "");
            Statement st = (Statement) conn.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                %>
                <tr>
                <td><%=rs.getInt("id") %> </td>
                <td><%=rs.getString("userName")%> </td>
                <td> <%=rs.getString("email")%></td> 
                <td><a href="update.jsp?id=<%=rs.getString("id")%>">update</a></td>
                <td><a href="delete?id=<%=rs.getString("id") %>"><button type="button" class="delete">Delete</button></a></td>
                </tr>
              <%
                 
            }
      }
      catch(Exception ex){
         ex.printStackTrace();
      }
      %>
  
</table>
