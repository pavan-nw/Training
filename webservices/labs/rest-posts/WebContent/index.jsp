<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BT Posts</title>
</head>
<body>
	<h1>Our Posts</h1>
	<form action="api/posts" method="post">
		<label>Message</label>
		<textarea rows="10" cols="120" name="message"></textarea>
		<input type="submit" value="Post" />
	</form>
</body>
</html>