package com.DAO;




import com.connection.DBConnection;
import com.entities.Employees;
import com.entities.jdbcPendingTickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeesDAO {
	
	private static Statement statement = null;
    Connection connection = null;

    public EmployeesDAO() {
        try {
            this.connection = DBConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean managerCheck(String username, String password) throws SQLException {
		int result = 0;
		String sql = "Select managercheck.checkId From managercheck inner join manager_check_junction on manager_check_junction.checkId = managercheck.checkId"
				+ " inner join employees on employees.empId = manager_check_junction.empId\r\n"
				+ " where employees.empFname = ? and employees.empPassword = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);		
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet resset = preparedStatement.executeQuery();
		while(resset.next()) { //convert to string for user		
			result = resset.getInt(1);
		}
		if (result == 1) {
			return true;
		}
		else
			return false;
	}
    
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
