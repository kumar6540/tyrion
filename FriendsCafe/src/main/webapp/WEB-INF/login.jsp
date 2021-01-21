<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.error{
color: red;
position: fixed;
text-align: left;
margin-left: auto;
}

</style>

<script type="text/javascript">

function validateuserName() {
	
	var username= document.getElementById('un').value;
	if(username.length <3){
		alert("Error: Username less then 3 char")
	
		return false;
	}else return true;
	
}


</script>


</head>
<body>

<h2 align="center">User Login</h2>
<form:form action="procced" method="post" modelAttribute="log" onsubmit="return validateuserName()">
<div align="center">
<p>
<label for="un"> User Name:</label>
<form:input id="un" path="uname"/>
<form:errors path="uname" cssClass = "error"/>
</p>
<p>
<label for="pass"> Password:</label>
<form:password  id="pass" path="pass" />
</p>
<input type="submit" value="proceed">

</div>


</form:form>

<a href="<c:url value="userregistration"/>"> Get Registration</a>



</body>
</html>