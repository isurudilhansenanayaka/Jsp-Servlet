<%-- 
    Document   : index
    Created on : Sep 10, 2019, 11:06:15 AM
    Author     : isuru_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body><br><br><br><br>
    <center><h1>Login</h1></center><br>
        <form action="Controller" method="POST">
            <table align="center">
                <tr>
                    <th align="right">Email: </th>
                    <td><input type="email" name="email" placeholder="Enter valid Email" required=""></td>
                </tr>
                <tr>
                    <th align="right">Password: </th>
                    <td><input type="password" name="password" placeholder="Enter Password" required=""></td>
                </tr>
                <tr>              
                    <td  colspan="0" align="center"><input class="btn btn-success" type="submit" value="LogIn"></td>
                    <p colspan="0" align="center">Don't have an account? <a href="signup.jsp">Register</a>.</p>
 
                </tr>
                
            </table>
            
        </form>
    </body>
</html>
