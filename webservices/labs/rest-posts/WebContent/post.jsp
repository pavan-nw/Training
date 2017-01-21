<%@page import="com.bt.rest.crud.domain.Post"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Posts</title>
</head>
<body>
	<h1>
		Post details for
		<%=((Post) request.getAttribute("post")).getId()%>
	</h1>
		<table>
			<tr>
				<td>Posted by</td>
				<td><%=((Post) request.getAttribute("post")).getUserId()%></td>
			</tr>
			<tr>
				<td>Message</td>
				<td><%=((Post) request.getAttribute("post")).getMessage()%></td>
			</tr>
		</table>
</body>
</html>