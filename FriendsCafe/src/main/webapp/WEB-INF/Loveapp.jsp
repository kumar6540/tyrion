<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

error{color:red; position: fixed;text-align: left;}

</style>

<meta charset="ISO-8859-1">
<title>Love Calculator</title>
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


<h1 align="center">Love Calculator</h1>
 <div align="center">
<form:form action="appresult" method="post" modelAttribute="uinfo">

<p>
<label for="un">User Name:</label>
   <form:input id="un" path="yName"/>
   <form:errors path="yName" cssClass="error"/>
   

</p>
<p>
<label for="cn">Crush Name:</label>
   <form:input id="cn" path="crushName"/>
   <form:errors path="crushName" cssClass="error"/>


</p>

 <input type="submit" value="Calculate">
</form:form>
 </div>

</body>

</html>