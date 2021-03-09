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

</head>


<body>
<h1 align="center">Bill</h1>

 <div align="center">
<form:form action="result" method="post" modelAttribute="bill">
<p>
<label for="cd">Credit Card:</label>
   <form:input id="cd" path="cardnum"/>
   <form:errors path="cardnum" cssClass="error"/>
   

</p>

<p>
<label for="am">Amount:</label>
   <form:input id="am" path="amount"/>
   <form:errors path="amount" cssClass="error"/>
   

</p>

<p>
<label for="dt">Date:</label>
   <form:input id="dt" path="date"/>
   <form:errors path="date" cssClass="error"/>
   

</p>


<p>
<label for="cur">Currency:</label>
   <form:input id="cur" path="currency"/>
   <form:errors path="currency" cssClass="error"/>
   

</p>
 <input type="submit" value="Pay">
</form:form>
</div>
</body>
</html>
