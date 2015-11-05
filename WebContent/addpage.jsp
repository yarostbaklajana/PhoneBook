<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/PhoneBook/add" method="post">
		<input type="text" name="firstName" value="<%= request.getAttribute("firstName") %>"><br> <input
			type="text" name="lastName" value="<%= request.getAttribute("lastName") %>"><br>
		<p>
			<a href="/PhoneBook/phonebook">Cancel</a> 
			<input type="submit"				value="Save">
		</p>
	</form>
	<p>
		<c:if test="${errorMessages ne null}">
			<ul>
				<c:forEach items="${errorMessages}" var="errorMessage">
					<li>${errorMessage}</li>
				</c:forEach>
			</ul>
		</c:if>
	</p>
</body>
</html>