<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Amount</th>
				<th>Customer Name</th>
			</tr>
		</thead>
		<c:forEach var="order" items="${ordersList}">
			<tr>
				<td>${order.id}</td>
				<td>${order.description}</td>
				<td>${order.amount}</td>
				<td>${order.customer.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>