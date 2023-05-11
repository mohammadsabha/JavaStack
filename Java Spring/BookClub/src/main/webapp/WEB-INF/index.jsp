<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="body">
   		<h1>Welcome!</h1>
   		<h3>Join our growing community.</h3>
   		<div class="sign">
   			<div class="register">
   				<h2>Register</h2>
   				<form:form action="/register" method="post" modelAttribute="newUser">
   					<form:label class="form-label" path="userName">User Name</form:label>
   					<form:input class="form-control" type="text" path="userName"></form:input>
   					<form:label class="form-label" path="email">Email</form:label>
   					<form:input class="form-control" type="text" path="email"></form:input>
   					<form:label class="form-label" path="password">Password</form:label>
   					<form:input class="form-control" type="password" path="password"></form:input>
   					<form:label class="form-label" path="confirm">Confirm Password</form:label>
   					<form:input class="form-control" type="password" path="confirm"></form:input>
   					<input class="button" type="submit" value="Submit">
   				</form:form>
   			</div>
   			<div class="login">
   				<h2>Log In</h2>
   				<form:form action="/login" method="post" modelAttribute="newLogin">
   					<form:label class="form-label" path="email">Email</form:label>
   					<form:input class="form-control" type="text" path="email"></form:input>
   					<form:label class="form-label" path="password">Password</form:label>
   					<form:input class="form-control" type="password" path="password"></form:input>
   					<input class="button" type="submit" value="Submit">
   				</form:form>
   			</div>
   		</div>
   </div>
</body>
</html>

