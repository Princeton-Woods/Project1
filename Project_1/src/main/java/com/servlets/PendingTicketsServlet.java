package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.DAO.PendingTicketDAO;
import com.entities.PendingTickets;
import com.entities.jdbcPendingTickets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PendingTicketsServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PendingTicketDAO pendDAO = new PendingTicketDAO();
		
		List<jdbcPendingTickets> listData;
		try {
			listData = pendDAO.getAllPendingTickets();
			request.setAttribute("listData", listData);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/mPendingTickets.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
