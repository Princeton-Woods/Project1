<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="all_js_css.jsp" %>
</head>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="card">
		
			<form action="LoginServlet" method="post" class = "box">
				<h1>Login</h1>
				<p id="invalid">${message}</p>
				
				<div class="form-group">
					<label>Username</label>
					<input type="text" name="username" id="username" class="form-control" placeholder="Enter Username" required/>
				</div>
			
				<div class="form-group">
					<label>Password</label>
					<input type="password" name="password" id="password" class="form-control" placeholder="Enter Password" required/>
				</div>
				
				<input type="submit" class="btn btn-primary" value="submit" />
			
			</form>
				</div>
			</div>
		</div>
	</div>


</html>