<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Add Customer</title>

<link  type="text/css"
       rel="stylesheet"
       href="${pageContext.request.contextPath }/CSS/style.css"/>
<link  type="text/css"
       rel="stylesheet"
       href="${pageContext.request.contextPath }/CSS/add-customer-style.css"/>

</head>
      
<body>
  
     <div id="wrapper">
           <div id="header">
           <h2>CRM - Customer RelationShip Manager</h2>
           
          </div>    
      </div>
      
      
      <div id="container"> 
      <div id="content"> 
      <h3> Save Customer</h3>
      <form:form action="saveCustomer" modelAttribute="thecustomer" method="Post">
      
      <form:hidden path="id"/>
      <table>
         <tbody>
          <tr>
            <td><label>First Name</label></td>
            <td><form:input path="firstname"/>
            </td>
      </tr>
      
         <tr>
            <td><label>Last Name</label></td>
            <td><form:input path="lastname"/>
            </td>
      </tr>
      
         <tr>
            <td><label>Email</label></td>
            <td><form:input path="email"/>
            </td>
      </tr>
         <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" Class="save"/>
            </td>
      </tr>
      
      
      </tbody>
      </table>
      
      
      </form:form>
      
      <div style="clear; both"></div>
      
      <p>
      <a href="list-customers">Back-to-list</a>
      
    </p>
      </div></div>
      
      

</body>
</html>