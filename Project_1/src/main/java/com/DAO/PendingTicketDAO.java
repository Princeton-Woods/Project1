package com.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Employees;
import com.entities.PendingEmployeeJunction;
import com.entities.PendingTickets;
import com.entities.PendingTypeJunction;

import com.ticket.helper.Factory;

//For PendingTickets list
import java.sql.*;

public class PendingTicketDAO {
	
	public boolean createTicket(String amount, String Description, String type, int empId) {
		PendingTickets ticket = new PendingTickets();
		PendingTypeJunction typeJunction = new PendingTypeJunction();
		PendingEmployeeJunction empJunction = new PendingEmployeeJunction();
		Date date = new Date();
		double dAmount = Double.parseDouble(amount);
		ticket.setAmount(dAmount);
		ticket.setDescription(Description);
		ticket.setTimeStamp(date);
		Session session = Factory.getFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(ticket);
		transaction.commit();
		String hql = "Select p.id FROM PendingTickets p order by p.id DESC";
		List result =  session.createQuery(hql)
			.setMaxResults(1)
			.list();
		int pendId = (int) result.get(0);
		hql = "Select t.id FROM TicketType t WHERE t.name= :name";
		result =  session.createQuery(hql)
				.setParameter("name", type)
				.list();
		int typeId = (int) result.get(0);
		
		typeJunction.setPendId(pendId);
		typeJunction.setTypeId(typeId);
		empJunction.setEmpId(empId);
		empJunction.setPendId(pendId);
		
		transaction = session.beginTransaction();
		session.save(typeJunction);
		session.save(empJunction);
		transaction.commit();
		return true;
	}
	
	public List<PendingTickets> getAllPendingTickets(int userId) {
		//Session session = Factory.getFactory().openSession();
		//String hql = "Select p FROM PendingTickets p inner join p.ticketType inner join p.empTicket WHERE p.id= id"; 
		List<PendingTickets> result;  //= session.createQuery(hql).setParameter("id",userId).list();
		
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql = "Select * FROM pendingreimbursements inner join reimbursementtype inner join employee_reimbursement_junction WHERE empId= ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);		
		preparedStatement.setInt(1, userId);
		ResultSet resset = preparedStatement.executeQuery();

		while(resset.next()) { //convert to string for user			
			result.add(new PendingTickets(resset.getDouble(1),resset.getString(2), resset.getDate(3)));
		}
		
		return result;
	}


}
