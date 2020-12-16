<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<% 

response.setHeader("cache-control", "no-cache,no-store,must-revalidate");

if(session.getAttribute("Username")==null){
	

	 // response.sendRedirect("login.jsp");
 
	   RequestDispatcher rd = request.getRequestDispatcher("/index");
		
		rd.forward(request, response);
}


%>

<a href="order">Let order Food</a>

<form:form action="logout" method="post">
<input type="submit" value="Logout">

</form:form>



</body>
</html>