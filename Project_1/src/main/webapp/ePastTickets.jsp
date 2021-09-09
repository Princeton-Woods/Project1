<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Past Tickets</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>

<div class="container">
		<h1>Past Tickets</h1>
		<form action="PastTicketsServlet" method="get">
			
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Amount</th>
			      <th scope="col">Description</th>
			      <th scope="col">Date</th>
			      <th scope="col">Type</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="ticket" items="${listData}">
				    <tr>
				        <td><c:out value="${ticket.amount}"/></td>
				        <td><c:out value="${ticket.description}"/></td>
				        <td><c:out value="${ticket.timeStamp}"/></td>
				        <td><c:out value="${ticket.type}"/></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<input type="submit" class="btn btn-primary" value="update" />
			<br>
			<br>
		</form>
	
	</div>

</body>
</html>