<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Book reg page</title>
</head>
<body>
<form action="bookcontroller" method="post">
	<input type="hidden" name="id" value="0">
	<table>
		<tr>
			<td>Enter Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Enter Title</td>
			<td><input type="text" name="title"></td>
		</tr>
		
		<tr>
			<td>Enter Price</td>
			<td><input type="text" name="price"></td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>