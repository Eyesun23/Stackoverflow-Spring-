<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
		table {
		    border-collapse: collapse;
		    width: 80%;
		    
		}
		
		td, th {
		    border: 2px solid grey;
		    text-align: left;
		    padding: 8px;
		}
		
	
		
		h1 {
		margin-top: 50px;
		text-align: center;
		}
		
		.container{
		margin-left: 200px;
		padding: 20px;
		margin-top: 50px;
		}
</style>
</head>
<body>
	<div class="header">
		<a href="/questions/new">New Question</a>
		<h1>Questions Dashboard</h1>
	</div>
	<div class="container">
		<table>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		<c:forEach items="${questions}" var="question">
			<tr>
				<td><a href="/questions/${question.id}"><c:out value="${question.content}" /></a></td>
				<td>
					<c:forEach items="${question.tags}" var="tag">
						<c:out value="${tag.name}, " />
					</c:forEach>
				</td>
		</c:forEach>
		</table>
	</div>
</body>
</html>