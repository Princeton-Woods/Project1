package com.servlets;


//Java Includes
//import com.ticket.Ticket;
import com.ticket.helper.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
//Servlet Includes
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Hibernate Includes
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AddServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try {
			String type = request.getParameter("type");
			double amount = Double.parseDouble(request.getParameter("amount"));
			String description = request.getParameter("description");
			
			//Ticket ticket = new Ticket( type, amount, description, new Date()); 

			Session session = Factory.getFactory().openSession();
			Transaction trans = session.beginTransaction();
			//session.save(ticket);
			trans.commit();
			session.close();
			
			//Test Html
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
