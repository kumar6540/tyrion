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
Hello ${uinfo.yName} !

Love Calculator Results <br>

           Relation b/W  ${uinfo.yName} and  ${uinfo.crushName} :   ${uinfo.loveResult }
   
   <br/>
   
   <a href="<c:url value="SendEmail"/>" >Send Result to your Email</a>
   

</body>
</html>