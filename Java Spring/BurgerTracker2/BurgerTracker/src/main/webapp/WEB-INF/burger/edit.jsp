<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
</head>
<body>
	<h1>Edit Burger</h1>
	<a href="/">go back</a>
<form:form action="/burger/${burger.id}" method="post" modelAttribute="burger">
    <input type="hidden" name="_method" value="put">
    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="restaurantName">Restaurant Name</form:label>
	        <form:errors path="restaurantName"/>
	        <form:input path="restaurantName"/>
	    </p>
	    <p>
	        <form:label path="rating">Rating</form:label>
	        <form:errors path="rating"/>     
	        <form:input type="number" path="rating"/>
	    </p> 
	    <p>
	        <form:label path="notes">Notes</form:label>
	        <form:errors path="notes"/>
	        <form:textarea path="notes"/>
	    </p>
    <input type="submit" value="Submit"/>
</form:form>

	
</body>
</html>