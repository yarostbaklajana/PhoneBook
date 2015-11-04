<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Styles/mainpage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Integer size = (Integer)request.getAttribute("size"); %>
	<%Integer i = 0; %>
	
	<p class="add">
		<a href="/PhoneBook/add"><button>Add new contact</button></a>
	</p>
	

	<table class="table table-striped">	
		<tr class="header">
			<td class="diez">#</td>
			<td class="first_colomn">First name</td>
			<td class="second_colomn">Last name</td>
			<td class="buttons"></td>
		</tr>


		<c:forEach items="${contacts}" var="current">
			<tr class="contacts">
				<td class="number"><%= i++ %></td>
				<td class="firstName"><c:out value="${current.firstName}" /></td>
				<td class="lastName"><c:out value="${current.lastName}" /></td>
				<td class="button">
					<form action="/PhoneBook/delete" method="post">
						<input type="hidden" name="id" value="${current.id}" /> <input
							type="submit" value="Delete"></input>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>





</body>
</html>