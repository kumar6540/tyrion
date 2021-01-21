<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% 

response.setHeader("cache-control", "no-cache,no-store,must-revalidate");

if(session.getAttribute("Username")==null){
	

	 // response.sendRedirect("login.jsp");
 
	   RequestDispatcher rd = request.getRequestDispatcher("/login");
		
		rd.forward(request, response);
}


%>


Hello ${username} !
<form:form action="emailconfirm" method="post" modelAttribute="Einfo">

<p>
<form:input path="Email"/>  <input type="submit" value="Send Email">
</p>

</form:form>


</body>
</html>