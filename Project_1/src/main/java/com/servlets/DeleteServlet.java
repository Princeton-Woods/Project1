package com.servlets;


import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.ticket.Ticket;
import com.ticket.helper.Factory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try {
			//String type = request.getParameter("type");
			//double amount = Double.parseDouble(request.getParameter("amount"));
			//String description = request.getParameter("description");
			int id = Integer.parseInt(request.getParameter("ticketId").trim());
			
			Session session = Factory.getFactory().openSession();
			Transaction trans = session.beginTransaction();
			//Ticket ticket = session.get( Ticket.class,id); 

			//session.delete(ticket);
			trans.commit();
			session.close();
			
			//Needs Html Redirect
			response.sendRedirect("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
