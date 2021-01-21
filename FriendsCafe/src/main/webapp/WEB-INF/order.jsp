<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Page</title>
</head>
<body>



<h1 align="center">Friends Cafe</h1>

<form:form action="process" method="post" modelAttribute="fitem" >

<div align="center">
<hr>
<label for="item_name">Item name :</label>

 <form:select path="item">  
          <form:option value="Dosa" label="Dosa"/>  
        <form:option value="idly" label="idly"/>  
        <form:option value="Uppma" label="Uppma"/>  
        <form:option value="Tea" label="Tea"/>  
        </form:select>  <input type="submit" value="order">
        <br><br>  

</div>


</form:form>




</body>
</html>