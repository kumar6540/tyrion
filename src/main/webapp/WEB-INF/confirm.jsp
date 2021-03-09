<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>

Payment Results <br>

Card: ${bill.cardnum}<br> Amount: ${bill.amount}  ${bill.currency.displayName}     <br>
Date: ${bill.date}



</body>
</html>