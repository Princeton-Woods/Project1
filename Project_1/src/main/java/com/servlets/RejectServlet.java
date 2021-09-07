package com.servlets;

import com.DAO.EmployeesDAO;
import com.DAO.PendingTicketDAO;
import com.entities.Employees;
//Java Includes
import com.ticket.helper.Factory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

//Servlet Includes
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Hibernate Includes
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RejectServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PendingTicketDAO pendDAO = new PendingTicketDAO();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			//List<Employee> employees = employeeDAO.getAllEmployees();
			String rejectId = request.getParameter("rejectId");
			int id = Integer.parseInt(rejectId);
			pendDAO.rejectTicket(id);
			RequestDispatcher rd = request.getRequestDispatcher("mPendingTickets.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
