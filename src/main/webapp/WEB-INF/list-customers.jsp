<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ page import="com.customer.utill.SortUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link  type="text/css"
       rel="stylesheet"
       href="${pageContext.request.contextPath }/CSS/style.css"/>
<title>Insert title here</title>
</head>
<body>
           
     <div id="wrapper">
           <div id="header">
           <h2>CRM - Customer RelationShip Manager</h2>
           
          </div>    
      </div>
      <div id="container"> 
      <div id="content">
      <!-- Add buttton for adding Customer -->
      
      <input type="button" value="Add Customer"
      onclick="window.location.href='ShowFormForAdd'; return false;"
      class="add-button"
      />
      
      <!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
            
            <!-- construct a sort link for first name -->
				<c:url var="sortLinkFirstName" value="/list-customers">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.first_name) %>" />
				</c:url>
				<!-- construct a sort link for first name -->
				<c:url var="sortLinkLastName" value="/list-customers">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.last_name) %>" />
				</c:url>
				<!-- construct a sort link for first name -->
				<c:url var="sortLinkEmail" value="/list-customers">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.email) %>" />
				</c:url>
            <table>
      <tr>
        <th><a href="${sortLinkFirstName}">First Name</a></th>
					<th><a href="${sortLinkLastName}">Last Name</a></th>
					<th><a href="${sortLinkEmail}">Email</a></th>
					<th>Action</th>
         <th>Remove</th>
         
      </tr>
      
      <c:forEach var="tempCustomer" items="${customers}">
      
      <!-- Get the id of each customer for Update link-->
      
      <c:url var="updatelink" value="/showUpdateForm">
      
      <c:param name="customerId" value="${tempCustomer.id }"/>
          </c:url>
           <!-- Get the id of each customer for Delete link-->
     
      <c:url var="deleteink" value="/Delete">
      
      <c:param name="customerId" value="${tempCustomer.id }"/>
      </c:url>
      <tr>
      <td> ${tempCustomer.firstname}   </td>
            <td> ${tempCustomer.lastname}   </td>   
               <td> ${tempCustomer.email}   </td>
               
               <td>
               <!-- Update link or Update Button -->
               <a href="${updatelink}">Update</a>
               
               </td>
               <td>
               <!-- Update link or Update Button -->
               <a href="${deleteink}"
               onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
               
               </td>
      </tr>
      </c:forEach>
      </table>
      
      <p>
      <a href="list-customers">Back-to-list</a>
      
    </p>
      
      </div>
      </div>





</body>
</html>