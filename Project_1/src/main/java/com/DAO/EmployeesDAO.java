package com.DAO;




import com.entities.Employees;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeesDAO {
	
	public List<Employees> getAllEmployees() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session.createQuery("FROM Employees").list();
	}
	
	public boolean verifyLogin(String username, String password) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		String hql = "Select e FROM Employees e WHERE e.username= :username and e.password= :password";
		List result =  session.createQuery(hql)
			.setParameter("username", username)
			.setParameter("password", password)
			.list();
		if (result.isEmpty()) {
			session.close();
			return false;
		}
		else
			session.close();
			return true;
	}
	
	public int getCurrentUserId(String username, String password) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		String hql = "Select e.id FROM Employees e WHERE e.username= :username and e.password= :password";
		List result =  session.createQuery(hql)
			.setParameter("username", username)
			.setParameter("password", password)
			.list();
		int iResult = (int) result.get(0);
		//String sResult = Integer.toString(iResult);
		return iResult;
	}
	
	public String getName(String username, String password) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		String hql = "Select e.fname FROM Employees e WHERE e.username= :username and e.password= :password";
		List result =  session.createQuery(hql)
			.setParameter("username", username)
			.setParameter("password", password)
			.list();
		String sResult = (String) result.get(0);
		return sResult;
	}

}
