<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Landing Page</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Employee Logged In</h1>
			<br>
			<h4>${welcome}</h4>
			<br>
			<br>
			<a href="http://localhost:8080/Project_1/ePastTickets.jsp">
				<button type="button" name="but" value="past" class="btn btn-primary">View Past Tickets</button>
			</a>
			<a href="http://localhost:8080/Project_1/eCreateTicket.jsp">
				<button type="button" name="but" value="create" class="btn btn-primary">Create Ticket</button>
			</a>
	</div>
</body>
</html>