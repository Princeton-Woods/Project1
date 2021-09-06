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
		
		<form action="LoginServlet" method="post">
			
			<p id="invalid">${message}</p>
			
			<div class="form-group">
				<label>Amount</label>
				<input type="text" name="username" id="username" class="form-control" placeholder="Enter Amount" required/>
			</div>
		
			<div class="form-group">
				<label>Description</label>
				<input type="text" name="password" id="password" class="form-control" placeholder="Enter Description" required/>
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
			
			<input type="submit" class="btn btn-primary" value="submit" />
		
		</form>
	
	</div>

</body>
</html>