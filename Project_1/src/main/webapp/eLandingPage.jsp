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
	<div class="row">
	<div class="col-md-6">
	<div class = "card">
	<div class = "boxlanding">
	
		<h1>Employee Logged In</h1>
		<h4>${welcome}</h4>
		
		<div class = "divider"></div>
		<div>
			<a href="http://localhost:8080/Project_1/eCreateTicket.jsp">
				<button type="button" name="but" value="create" class="btn btn-success buttonsize">Create Ticket</button>
			</a>
		</div>
		
		<div class = "divider"></div>
		
		<div>
			<a href="http://localhost:8080/Project_1/ePastTickets.jsp">
				<button type="button" name="but" value="past" class="btn btn-primary buttonsize">View Past Tickets</button>
			</a>
		</div>
		
			

	
	</div>
	</div>
	</div>
	</div>
	</div>
	
</body>
</html>