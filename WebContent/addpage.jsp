<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/PhoneBook/add" method="post">
		<input type="text" name="firstName"><br> <input
			type="text" name="lastName"><br>
		<p>
			<a href="/PhoneBook/phonebook">Cancel</a> 
			<input type="submit" value="Save">
		</p>
	</form>
</body>
</html>