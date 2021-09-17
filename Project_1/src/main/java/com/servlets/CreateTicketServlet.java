package com.servlets;

import com.DAO.PendingTicketDAO;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
//Servlet Includes
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CreateTicketServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PendingTicketDAO pendDAO = new PendingTicketDAO();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			//List<Employee> employees = employeeDAO.getAllEmployees();
			String amount = request.getParameter("amount");
			String description = request.getParameter("description");
			String type = request.getParameter("type");
			//String sEmpId = (String) request.getSession().getAttribute("currentUserId");
			int empId = (int) request.getSession().getAttribute("currentUserId");
			//int empId = Integer.parseInt(sEmpId);
			
			if (pendDAO.createTicket(amount, description, type, empId) == true) {
				request.setAttribute("message", "Succesfully submitted.");
				RequestDispatcher rd = request.getRequestDispatcher("/eCreateTicket.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
