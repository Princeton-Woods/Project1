package com.servlets;

//Java Includes
//import com.ticket.Ticket;
import com.ticket.helper.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
//Servlet Includes
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Hibernate Includes
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ModifyServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try {
			String type = request.getParameter("type");
			double amount = Double.parseDouble(request.getParameter("amount"));
			String description = request.getParameter("description");
			int id = Integer.parseInt(request.getParameter("ticketId").trim());
			

			Session session = Factory.getFactory().openSession();
			Transaction trans = session.beginTransaction();
			//Ticket ticket = session.get( Ticket.class,id); 
			//Init
			//ticket.setType(type);
			//ticket.setDescription(description);
			//ticket.setAmount(amount);
			//ticket.setTimeStamp(new Date());
			//
			//session.update(ticket);
			trans.commit();
			session.close();
			
			//Needs Html Redirect
			response.sendRedirect("");
			
			//Test Html
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
