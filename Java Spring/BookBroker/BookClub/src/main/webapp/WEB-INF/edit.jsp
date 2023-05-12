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
   			<h1>Change Your Entry</h1>
   			<a href="/books">Back to the shelves</a>
   		</div>
		<div class="Shelf">
	   		<form:form action="/book/${id}" method="post" modelAttribute="book">
	   			<input type="hidden" name="_method" value="put">
	   			<!-- <input type="hidden" name="user_id" value="${user.id}">"/users/${user_id}/books/${bookId}/edit" -->
	   			<form:label class="form-label" path="title">Title</form:label>
	   			<form:input class="form-control" type="text" path="title" value="${book.title}"></form:input>
	   			<form:label class="form-label" path="author">Author</form:label>
	   			<form:input class="form-control" type="text" path="author" value="${book.author}"></form:input>
	   			<form:label class="form-label" path="thought">My Thoughts</form:label>
	   			<form:input class="form-control" type="text-area" path="thought" value="${book.thought}"></form:input>
	   			<input class="button" type="submit" value="Submit">
	   		</form:form>
   		</div>
   </div>
</body>
</html>

