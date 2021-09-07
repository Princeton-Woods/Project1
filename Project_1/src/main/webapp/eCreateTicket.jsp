<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Ticket</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
	<div class="container">		
		<form action="CreateTicketServlet" method="post" class="box">
			<div class="form-group">
				<h1>Create Ticket</h1>
			<p class = "text-muted" id="invalid">${message}</p>
				<label>Amount</label>
				<input type="text" name="amount" id="username" placeholder="Enter Amount" required/>
			</div>
			<div class="form-group">
				<label>Description</label>
				<input type="text" name="description" id="password" class="form-control" placeholder="Enter Description" maxlength="255" required/>
			</div>
			<div class="form-group">
				<label for="type">Choose a Type</label>
				<select name="type" id="type">
  					<option value="Lodging">Lodging</option>
  					<option value="Travel">Travel</option>
  					<option value="Food">Food</option>
  					<option value="Other">Other</option>
				</select>
			</div>
			<input type="submit" class="btn btn-primary" value="Submit" />
			<br>
			<br>
		</form>
		<a href='http://localhost:8080/Project_1/eLandingPage.jsp'><button class="btn btn-primary">Previous</button></a>
	</div>

</body>
</html>