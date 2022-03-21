<%@page import="com.bookapp.model.dao.Book"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book information</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>title</th>
				<th>price</th>
				<th>delete</th>
				<th>update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td>${book.title}</td>
					<td>${book.price}</td>
					<td><a href="bookcontroller?action=del&id=<c:out value="${book.id}"/>">delete</a></td>
					<td><a href="bookcontroller?action=update&id=<c:out value="${book.id}"/>">update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="bookcontroller?action=add">add new book</a>
</body>
</html>