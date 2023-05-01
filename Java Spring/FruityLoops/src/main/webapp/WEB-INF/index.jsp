<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruits Loop</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="body">
	<h1>Fruit Store</h1>
	<div class="container">
		<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="onefruit" items="${fruits}">
    <tr>
      <td><c:out value="${onefruit.name}"/></td>
      <td><c:out value="${onefruit.price}"/></td>
    </tr>
    </c:forEach>
    
  </tbody>
</table>
	</div>
</div>	
</body>
</html>