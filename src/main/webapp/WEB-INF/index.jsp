<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>       

<html>
<body>
<h2>Hello World!</h2>
<p>
User: <security:authentication property="principal.username"/>
<br><br>
Roles: <security:authentication property="principal.authorities"/>
</p>

<security:authorize access="hasAnyRole('MANAGER','ADMIN')">

<a href="list-customers">Get customers list</a>

</security:authorize>

					<!-- LogOut Button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
						   method="POST" class="form-horizontal">

<input type="submit" value="logout">


</form:form>
</body>
</html>
