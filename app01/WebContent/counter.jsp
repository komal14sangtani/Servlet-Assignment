<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	private int counter=0;
%>

<%	//scriplet
	//pure java code
	out.print(counter++);
	out.print("<br>");
	out.print("powered by harman");
%>
</body>
</html>