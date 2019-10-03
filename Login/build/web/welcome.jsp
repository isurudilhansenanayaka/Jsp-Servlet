<%-- 
    Document   : nwelcome
    Created on : Sep 10, 2019, 1:54:49 PM
    Author     : isuru_s
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Welcome Page</title>
    </head>
    
         <form class="form" role="form" action="logout"  method="POST">
             
             <h1 class="text-success" align="right">Hello!  <%= session.getAttribute("username1")  %> Successful Login!</h1>
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
    
  </tr>
  
     <c:forEach var="user" items="${AllUsers}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.userName}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    
                    
                </tr>
    </c:forEach>
          <nav aria-label="Navigation for countries">
                <ul class="pagination">
                    
                    <!-- previous tab -->
                    <!-- if currentPagteNumber is not equal to 1, we need to go to the previous pages  -->
                    <c:if test="${currentPageNumber != 1}">
                        <li class="page-item"><a class="page-link" 
                            href="retrieve?numberOfRows=${numberOfRows}&currentPageNumber=${currentPageNumber-1}">Previous</a>
                        </li>
                    </c:if>
                    
                   <!-- numbered tabs -->
                   <!-- run a foreach loop begins with 1 to numberOfPages -->
                    <c:forEach begin="1" end="${numberOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPageNumber eq i}">
                                <li class="page-item active"><a class="page-link">
                                        ${i} <span class="sr-only">(current)</span></a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" 
                                    href="retrieve?numberOfRows=${numberOfRows}&currentPageNumber=${i}">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                    <!-- next tab -->            
                    <c:if test="${currentPageNumber < numberOfPages}">
                        <li class="page-item"><a class="page-link" 
                            href="retrieve?numberOfRows=${numberOfRows}&currentPageNumber=${currentPageNumber+1}">Next</a>
                        </li>
                    </c:if>              
                </ul>
            </nav>      
</table>
