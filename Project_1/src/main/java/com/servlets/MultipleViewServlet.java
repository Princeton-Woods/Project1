package com.servlets;

import com.DAO.EmployeesDAO;
import com.DAO.PendingTicketDAO;
import com.entities.Employees;
import com.entities.jdbcPendingTickets;
import com.entities.jdbcReimbursementTicket;
//Java Includes
import com.ticket.helper.Factory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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


public class MultipleViewServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		EmployeesDAO employeeDAO = new EmployeesDAO();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			String toggle = request.getParameter("toggle");
			
			if(toggle != null) {
				request.getSession().setAttribute("toggle", toggle);
				RequestDispatcher rd = request.getRequestDispatcher("/multipleViews.jsp");
				rd.forward(request, response);
			}
			else {}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PendingTicketDAO pendDAO = new PendingTicketDAO();
		
		String type = (String) request.getSession().getAttribute("toggle");
		request.setAttribute("type", type);
		try {
			if (type.equals("approved")) {
				List<jdbcReimbursementTicket> listData;
				listData = pendDAO.getAllApprovedTickets();
				request.setAttribute("listData", listData);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/multipleViews.jsp");
				rd.forward(request, response);
			}
			else if (type.equals("rejected")) {
				List<jdbcReimbursementTicket> listData;
				listData = pendDAO.getAllRejectedTickets();
				request.setAttribute("listData", listData);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/multipleViews.jsp");
				rd.forward(request, response);
			}
			else if (type.equals("pending")) {
				List<jdbcPendingTickets> listData;
				listData = pendDAO.getAllPendingTickets();
				request.setAttribute("listData", listData);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/multipleViews.jsp");
				rd.forward(request, response);
			}
			else {
				List<jdbcPendingTickets> listData;
				listData = pendDAO.getAllPendingTickets();
				request.setAttribute("listData", listData);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/multipleViews.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
