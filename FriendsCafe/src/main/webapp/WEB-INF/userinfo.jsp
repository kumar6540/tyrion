<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Registration Successful ...

User Details Name:${info.firstName} ${info.lastName}
             Gender: ${info.gender}<br>
             UserName:${info.uname}<br>
             PassWord:${info.password }<br>
             Communication Details<br>
             Email:${info.communicationdto.email }<br>
             Phone Number:${info.communicationdto.phone}<br>
<br>
<a href="<c:url value="login"/>">User Login</a>




</body>
</html>