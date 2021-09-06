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

public class PendingTicketDAO {
	
	public boolean createTicket(String amount, String Description, String type, int empId) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		PendingTickets ticket = new PendingTickets();
		PendingTypeJunction typeJunction = new PendingTypeJunction();
		PendingEmployeeJunction empJunction = new PendingEmployeeJunction();
		Date date = new Date();
		double dAmount = Double.parseDouble(amount);
		ticket.setAmount(dAmount);
		ticket.setDescription(Description);
		ticket.setTimeStamp(date);
		Session session = factory.openSession();
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
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		String hql = "Select p FROM PendingTickets p inner join p.ticketType inner join p.empTicket WHERE p.id= :id"; 
		List<PendingTickets> result= session.createQuery(hql)
				.setParameter("id", userId)
				.list();
		return result;
	}


}
