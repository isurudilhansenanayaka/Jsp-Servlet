<%-- 
    Document   : update
    Created on : Sep 20, 2019, 10:06:36 AM
    Author     : isuru_s
--%>

<%@page import="com.servlet.connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
   
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    conn=(Connection) connection.db();
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    try{
    st=(Statement) conn.createStatement();
    String sql ="SELECT * FROM user WHERE userName=userName";
    
    rs = st.executeQuery(sql);
    
    
while(rs.next()){
    
%>
s
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>update Page</title>
    </head>
    <body>
        <script>
            function reload(){
                Location.reload();
            }
        </script>
        <div class="container">
          
            <div class="row">
    <div class="col">
      1 of 3
    </div>
    <div class="col-5">
      <form class="form"  action="update" name="update">
                
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">User Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="userName" placeholder="User Name" class="form-control" 
                               autofocus name= "userName" required="" value="<%= rs.getString("userName")  %>">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email* </label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" class="form-control" name= "email" required="" 
                               value="<%= rs.getString("email")  %>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="Password" class="form-control" name= "password" required=""
                               value="<%= rs.getString("Password")  %>" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Re-Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="Password" class="form-control" name= "passwordc" required="" accept=""
                               value="<%= rs.getString("Password")  %>">
                    </div>
                </div>
               
                
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <span class="help-block">*Required fields</span>
                    </div>
                </div>
                 <p account></p> 
                
                <div class="container signin">
                    <button colspan="2" align="right" type="submit" onclick="reload()" class="btn btn-success">Update</button>
                
                </div>
            </form> <!-- /form -->
    </div>
    <div class="col">
      3 of 3
    </div>
  </div>
        </div>
    <%

conn.close();
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>
