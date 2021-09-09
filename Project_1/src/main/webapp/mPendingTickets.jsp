<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Tickets</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>

<div class="container">
		<h1>Pending Tickets</h1>
		<form action="PendingTicketsServlet" method="get">
			
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Amount</th>
			      <th scope="col">Description</th>
			      <th scope="col">Date</th>
			      <th scope="col">Type</th>
			      <th scope="col">Emp Id</th>
			      <th scope="col">Approve</th>
			      <th scope="col">Reject</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="ticket" items="${listData}">
				    <tr>
				    	<td><c:out value="${ticket.id}"/></td>
				        <td><c:out value="${ticket.amount}"/></td>
				        <td><c:out value="${ticket.description}"/></td>
				        <td><c:out value="${ticket.timeStamp}"/></td>
				        <td><c:out value="${ticket.type}"/></td>
				        <td><c:out value="${ticket.empId}"/></td>
				     <form action="ApproveServlet" method="post">
				        <td><button type="submit" name="approveId" value="${ticket.id}" class="btn btn-primary">Approve</button></td>
				     </form>
					 <form action="RejectServlet" method="post">
				        <td><button type="submit" name="rejectId" value="${ticket.id}" class="btn btn-primary">Reject</button></td>
				     </form>
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