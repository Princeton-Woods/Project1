<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>

<div class="container">
		<h1>Login</h1>
		<h1>${listData}</h1>
		<form action="PastTicketsServlet" method="get">
			
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Employee Id</th>
			      <th scope="col">Amount</th>
			      <th scope="col">Description</th>
			      <th scope="col">Date</th>
			      <th scope="col">Type</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="ticket" items="${listData}">
				    <tr>
				        <td>${ticket.empId}</td>
				        <td>${ticket.amount}</td>
				        <td>${ticket.description}</td>
				        <td>${ticket.timeStamp}</td>
				        <td>${ticket.name}</td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<input type="submit" class="btn btn-primary" value="submit" />
		</form>
	
	</div>

</body>
</html>