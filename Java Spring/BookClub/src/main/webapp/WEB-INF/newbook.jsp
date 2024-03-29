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
    <title>Book Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class="body">
   		<div class="nav">
   			<h1>Add a Book to Your 	Shelf!</h1>
   			<a href="/books">Back to the shelves</a>
   		</div>
		<div class="Shelf">
	   		<form:form action="/shelfs/${user_id}/books/new" method="post" modelAttribute="book">
	   			<form:label class="form-label" path="title">Title</form:label>
	   			<form:input class="form-control" type="text" path="title"></form:input><br>
	   			<form:errors path="title" class="text-danger"/>
	   			<form:label class="form-label" path="author">Author</form:label>
	   			<form:input class="form-control" type="text" path="author"></form:input><br>
	   			<form:errors path="author" class="text-danger"/>
	   			<form:label class="form-label" path="thought">My Thoughts</form:label>
	   			<form:input class="form-control" type="text-area" path="thought"></form:input><br>
	   			<form:errors path="thought" class="text-danger"/>
	   			<input class="button" type="submit" value="Submit">
	   		</form:form>
   		</div>
   </div>
</body>
</html>

