<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

<a href="<c:url value="order"/>">Let order Food</a>

<form:form action="logout" method="post">
<input type="submit" value="Logout">

</form:form>
<a href="<c:url value="Loveapp"/>"> Love Calculator</a>



</body>
</html>