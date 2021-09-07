package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.DAO.PendingTicketDAO;
import com.entities.PendingTickets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PastTicketsServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PendingTicketDAO pendDAO = new PendingTicketDAO();
		
		int empId = (int) request.getSession().getAttribute("currentUserId");
		List<PendingTickets> listData = null;
		try {
			listData = pendDAO.getAllPendingTickets(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listData", listData);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ePastTickets.jsp");
		rd.forward(request, response);
	}

}
