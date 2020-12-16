<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<script type="text/javascript">

function validateuserName() {
	
	var username= document.getElementById('un').value;
	if(username.length <1){
		alert("user name should not be empty")
	
		return false;
	}else return true;
	
}


</script>
<style type="text/css">
.error{
color: red;
position: fixed;
text-align: left;
margin-left: auto;
}

</style>


</head>
<body>
<h2 align="center">Registration</h2>
<form:form action="Registration" method="post" modelAttribute="info"  onsubmit="return validateuserName()">
<div align="center">
<p>
<label for="fn"> First Name:</label>
<form:input  id="fn" path="firstName"/>
</p>

<p> <label for="ln">Last Name:</label>
<form:input  id="ln" path="lastName"/></p>
<p>
<label for="un"> User Name:</label>
<form:input id="un" path="uname"/>
</p>
<p>
<label for="pass"> Password:</label>
<form:password  id="pass" path="password" />
</p>

<p>
<label for="gn">Gender :</label>
   Male<form:radiobutton id="gn"  path="gender" value="Male"/>
   Female<form:radiobutton id="gn" path="gender" value="Female"/>
</p>

<p>
<label for="ag"> User Age:</label>
<form:input id="ag" path="age"/>
<form:errors path="age" cssClass="error"></form:errors>
</p>


<h3>Communication</h3>
<p>
<label for="em"> Email:</label>
<form:input id="em" path="communicationdto.Email"/>
</p>

<p>
<label for="ph"> Phone:</label>
<form:input id="ph" path="communicationdto.phone"/>
</p>


 <input type="submit" value="Register">
</div>
</form:form>




</body>
</html>