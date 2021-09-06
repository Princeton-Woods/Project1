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
		<h1>Create Ticket</h1>
		
		<form action="CreateTicketServlet" method="post">
			
			<p id="invalid">${message}</p>
			
			<div class="form-group">
				<label>Amount</label>
				<input type="text" name="amount" id="username" class="form-control" placeholder="Enter Amount" required/>
			</div>
		
			<div class="form-group">
				<label>Description</label>
				<input type="text" name="description" id="password" class="form-control" placeholder="Enter Description" maxlength="255" required/>
			</div>
			<div class="form-group">
				<label for="type">Choose a car:</label>
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
		<a href='http://localhost:8080/Project_1/eLandingPage.jsp'><button class="btn btn-primary">Back</button></a>
	</div>

</body>
</html>