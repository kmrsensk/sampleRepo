<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Health" %>
<%
	Health h = (Health)request.getAttribute("health");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
	<h1>結果</h1>
	<p>
		身長：<%= h.getHeight() %><br>
		体重：<%= h.getWeight() %><br>
		BMI：<%= h.getBmi() %><br>
		体型：<%= h.getBodyType() %>
	</p>
	<form action = "HealthCheck" method="get">
		<input type = "submit" value="戻る">
	</form>
</body>
</html>