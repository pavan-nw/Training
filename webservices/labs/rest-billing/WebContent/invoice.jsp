<%@page import="com.bt.jaxb.model.Invoice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
</head>
<body>
	<h1>Invoice</h1>
	<form id="invoiceForm">
		<span>Account Number</span><span><input type="text"
			name="accountNumber"
			value='<%=((Invoice) request.getAttribute("invoice")).getCustomer()
					.getAccountNumber()%>' /></span>
	</form>
</body>
</html>