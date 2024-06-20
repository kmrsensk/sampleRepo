<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String str = (String)request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
	<h1>あれ？</h1>
	<p>
		<%= str %>
	</p>
	<form action = "HealthCheck" method="get">
		<input type = "submit" value="戻る">
	</form>
</body>
</html>