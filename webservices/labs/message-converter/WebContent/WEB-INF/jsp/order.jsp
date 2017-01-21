<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Details</title>
</head>
<body>
	<p>
	<h3>Order Details</h3>
	</p>
	<table border=1>
		<tr>
			<td><b>Order Id</b></td>
			<td>${myOrder.id}</td>
		</tr>
		<tr>
			<td><b>Order Description</b></td>

			<td>${myOrder.description}</td>
		</tr>
		<tr>
			<td><b>Order Amount</b></td>

			<td>${myOrder.amount}</td>
		</tr>
		<tr>
			<td><b>Customer Name</b></td>
			<td>${myOrder.customer.name}</td>
		</tr>
	</table>
</body>
</html>