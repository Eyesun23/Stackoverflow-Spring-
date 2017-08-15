<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
	h1 {
	text-align: center;
	margin-top: 30px;
	}
	
	.container {
	text-align: center;
	
	}
	
	input {
	width: 300px;
	height: 100px;
	margin-top: 20px;
	}
	
	.gooz {
	width: 100px;
	margin-top: 30px;
	}
</style>

</head>
<body>
	<div class="header">
		<h1>What is your question?</h1>
	</div>
	
	<div class="container">
		<form action="/questions/create" method="GET">
			<label for="content">Question:</label>
			<input type="text" name="content">
			
			<label for="tags"><br>Tags:</label>
			<input type="text" name="tags"/><br>
			
			<input class="gooz" type="submit" value="Ask Question"/>
		</form>
	
	</div>
</body>
</html>