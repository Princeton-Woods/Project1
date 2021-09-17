<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Tickets</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>

<div class="container">
		<h1>All Tickets</h1>
		<br>
		<p id="invalid">${type}</p>
		<form action="MultipleViewServlet" method="post">
		<div class="btn-group btn-group-toggle" data-toggle="buttons">
		  <label class="btn btn-warning">
		    <input type="radio" name="toggle" value="pending" id="option1" onClick="submit"> Pending
		  </label>
		  <div class = "dividerView"></div>
		  <label class="btn btn-success">
		    <input type="radio" name="toggle" value="approved" id="option2"> Approved
		  </label>
		  <div class = "dividerView"></div>
		  <label class="btn btn-danger">
		    <input type="radio" name="toggle" value="rejected" id="option3"> Rejected
		  </label>
		</div>
		<div class = "dividerView"></div>
		<input type="submit" class="btn btn-primary" value="Set Toggle" />
		</form>>
		<form action="MultipleViewServlet" method="get">
			
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