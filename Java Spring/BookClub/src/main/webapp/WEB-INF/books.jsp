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
		<div class="nav">
			<div class="leftNav">
				<h1>Welcome, <c:out value="${thisUser.userName}"/>!</h1>
				<p>Books from everyone's shelves</p>
			</div>
			<div class="rightNav">
				<a href="/">LogOut</a><br>
				<a href="/books/new">+ Add to my shelf!</a>
			</div>
		</div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Title</th>
		      <th scope="col">Author Name</th>
		      <th scope="col">Posted By</th>
		    </tr>
		  </thead>
		  <tbody>
			  <c:forEach var="book" items="${allBooks}">
			    <tr>
			      <td scope="row"><c:out value="${book.id}"/></td>
			      <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
			      <td><c:out value="${book.author}"/></td>
			      <td><c:out value="${thisUser.userName}"/></td>
			    </tr>
			   </c:forEach> 
		   </tbody>
		</table>	
	</div>  
</body>
</html>

