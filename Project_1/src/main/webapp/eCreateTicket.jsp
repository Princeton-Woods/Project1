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
	<div class="row">
    <div class="col-md-6">
		<div class="card">
		<form action="CreateTicketServlet" method="post" class = "box">
			<h1>Create Ticket</h1>
			<p id="invalid">${message}</p>
			

				<label>Amount</label>
				<input type="text" name="amount" id="username" class="form-control" placeholder="Enter Amount" maxlength="6" required/>

		

				<label>Description</label>
				<input type="text" name="description" id="password" class="form-control" placeholder="Enter Description" maxlength="255" required/>

			<div class="dropdown">
				<label for="type">Choose a type:</label>
				<div>
				<select class = "btn btn-secondary dropdown-toggle" name="type" id="type">
  					<option class = "dropdown-item" value="Lodging">Lodging</option>
  					<option class = "dropdown-item" value="Travel">Travel</option>
  					<option class = "dropdown-item" value="Food">Food</option>
  					<option class = "dropdown-item" value="Other">Other</option>
				</select>
				</div>
			</div>
			
			<input type="submit" class="btn btn-primary" value="Submit" />

		</form>
	</div>
	</div>
	</div>
	</div>

</body>
</html>