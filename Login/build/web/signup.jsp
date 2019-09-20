<%-- 
    Document   : signup
    Created on : Sep 10, 2019, 2:32:08 PM
    Author     : isuru_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script type="text/javascript">
    function validation(){
        uname=document.signup.userName.values;
        if(uname=""){
            alert("Enter User Name");
            document.username.focus();
            return false;
        }
    }
    
</script>
    </head>
    <body>
       <div class="container">
           <form class="form"  action="data.jsp" name="signup">
                <h2>Registration</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">User Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="userName" placeholder="User Name" class="form-control" autofocus name= "userName" required="">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email* </label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" class="form-control" name= "email" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="Password" class="form-control" name= "password" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Re-Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="Password" class="form-control" name= "passwordc" required="">
                    </div>
                </div>
               
                
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <span class="help-block">*Required fields</span>
                    </div>
                </div>
                 <p account></p> 
                
                <div class="container signin">
                    <button colspan="2" align="right" type="submit" class="btn btn-success">Register</button>
                <p>Already have an account? <a href="index.jsp">Sign in</a>.</p>
                </div>
            </form> <!-- /form -->
        </div>
    </body>
</html>
