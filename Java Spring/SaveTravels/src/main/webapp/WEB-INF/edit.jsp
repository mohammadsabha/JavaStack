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
    <title>Edit Expense</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="body">
		<div class="nav">
			<h1>Edit Expense</h1>
			<a href="/">Go Back</a>
		</div>
		<form:form action="/expense/${travel.id}" method="post" modelAttribute="travel">
			<input type="hidden" name="_method" value="put">
    			<div class="input-group mb-3">
  					<span class="input-group-text" id="inputGroup-sizing-default">Expense Name</span>
  					<input type="text" class="form-control" name="name" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
				</div>
				<div class="input-group mb-3">
  					<span class="input-group-text" id="inputGroup-sizing-default">Vendor</span>
  					<input type="text" class="form-control" name="vendor" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
				</div>
				<div class="input-group mb-3">
  					<span class="input-group-text" id="inputGroup-sizing-default">Amount</span>
  					<input type="text" class="form-control" name="amount" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
				</div>
    			<div class="input-group">
  					<span class="input-group-text">Description</span>
  					<textarea class="form-control" name="description" aria-label="With textarea"></textarea>
				</div>
	    		<button type="submit" class="btn btn-primary">Submit</button>
    		</form:form>
	</div>	
</body>
</html>