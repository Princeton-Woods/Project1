package com.servlets;

import com.DAO.EmployeesDAO;
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


public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		EmployeesDAO employeeDAO = new EmployeesDAO();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			//List<Employee> employees = employeeDAO.getAllEmployees();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(employeeDAO.verifyLogin(username, password) == true) {
				String name = employeeDAO.getName(username, password);
				String welcome = "Welcome "+name+"!";
				//String id = employeeDAO.getCurrentUserId(username, password);
				request.getSession().setAttribute("currentUserId", employeeDAO.getCurrentUserId(username, password));
				request.setAttribute("welcome", welcome);
				RequestDispatcher rd = request.getRequestDispatcher("eLandingPage.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "Invalid login please try again.");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
