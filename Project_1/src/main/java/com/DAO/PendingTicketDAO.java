package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Employees;
import com.entities.PendingEmployeeJunction;
import com.entities.PendingTickets;
import com.entities.PendingTypeJunction;
import com.entities.jdbcPendingTickets;
import com.entities.jdbcReimbursementTicket;
import com.connection.DBConnection;

public class PendingTicketDAO {
	
	private static Statement statement = null;
    Connection connection = null;

    public PendingTicketDAO() {
        try {
            this.connection = DBConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
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
	
	public List<jdbcPendingTickets> getAllPendingTickets(int userId) throws SQLException {
		List<jdbcPendingTickets> tickets = new ArrayList<>();
		String sql = "Select pendingreimbursements.pendAmt, pendingreimbursements.pendDescription, pendingreimbursements.pendDate, reimbursementtype.typeName FROM pendingreimbursements" + 
				" inner join pending_type_junction On pendingreimbursements.pendId = pending_type_junction.pendId" + 
				" inner join reimbursementtype On pending_type_junction.typeId = reimbursementtype.typeId" + 
				" inner join pending_reimbursement_junction On pending_reimbursement_junction.pendId = pending_type_junction.pendId" + 
				" where empId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);		
		preparedStatement.setInt(1, userId);
		ResultSet resset = preparedStatement.executeQuery();

		while(resset.next()) { //convert to string for user			
			jdbcPendingTickets pend = new jdbcPendingTickets();
			pend.setAmount(resset.getDouble(1));
			pend.setDescription(resset.getString(2));
			pend.setTimeStamp(resset.getDate(3));
			pend.setType(resset.getString(4));
			tickets.add(pend);
		}
		return tickets;
	}
	
	public List<jdbcPendingTickets> getAllPendingTickets() throws SQLException {
		List<jdbcPendingTickets> tickets = new ArrayList<>();
		String sql = "Select PendingReimbursements.pendId, PendingReimbursements.pendAmt, PendingReimbursements.pendDescription, PendingReimbursements.pendDate, ReimbursementType.typeName, pending_reimbursement_junction.empId FROM PendingReimbursements"
				+ " inner join pending_type_junction On PendingReimbursements.pendId = pending_type_junction.pendId"
				+ " inner join ReimbursementType On pending_type_junction.typeId = ReimbursementType.typeId"
				+ " inner join pending_reimbursement_junction On pending_reimbursement_junction.pendId = pending_type_junction.pendId"
				+ " order by PendingReimbursements.pendId";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);	
		ResultSet resset = preparedStatement.executeQuery();

		while(resset.next()) { //convert to string for user			
			jdbcPendingTickets pend = new jdbcPendingTickets();
			pend.setId(resset.getInt(1));
			pend.setAmount(resset.getDouble(2));
			pend.setDescription(resset.getString(3));
			pend.setTimeStamp(resset.getDate(4));
			pend.setType(resset.getString(5));
			pend.setEmpId(resset.getInt(6));
			tickets.add(pend);
		}
		return tickets;
	}
	
	public List<jdbcReimbursementTicket> getAllApprovedTickets() throws SQLException {
		List<jdbcReimbursementTicket> tickets = new ArrayList<>();
		String sql = "Select Reimbursements.reimAmt, Reimbursements.reimDescription, Reimbursements.reimDate, ReimbursementType.typeName FROM Reimbursements"
				+ " inner join reimbursement_type_junction On Reimbursements.reimId = reimbursement_type_junction.reimId"
				+ " inner join ReimbursementType On reimbursement_type_junction.typeId = ReimbursementType.typeId"
				+ " inner join employee_reimbursement_junction On employee_reimbursement_junction.reimId = reimbursement_type_junction.reimId"
				+ " inner join reimbursement_decision_junction on reimbursement_decision_junction.reimId = Reimbursements.reimId"
				+ " inner join ReimbursementDecision on ReimbursementDecision.decisionId = reimbursement_decision_junction.decisionId"
				+ " Where ReimbursementDecision.decisionId = 1";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);	
		ResultSet resset = preparedStatement.executeQuery();

		while(resset.next()) { //convert to string for user			
			jdbcReimbursementTicket ticket = new jdbcReimbursementTicket();
			ticket.setAmount(resset.getDouble(1));
			ticket.setDescription(resset.getString(2));
			ticket.setTimeStamp(resset.getDate(3));
			ticket.setType(resset.getString(4));
			tickets.add(ticket);
		}
		return tickets;
	}
	
	public List<jdbcReimbursementTicket> getAllRejectedTickets() throws SQLException {
		List<jdbcReimbursementTicket> tickets = new ArrayList<>();
		String sql = "Select Reimbursements.reimAmt, Reimbursements.reimDescription, Reimbursements.reimDate, ReimbursementType.typeName FROM Reimbursements"
				+ " inner join reimbursement_type_junction On Reimbursements.reimId = reimbursement_type_junction.reimId"
				+ " inner join ReimbursementType On reimbursement_type_junction.typeId = ReimbursementType.typeId"
				+ " inner join employee_reimbursement_junction On employee_reimbursement_junction.reimId = reimbursement_type_junction.reimId"
				+ " inner join reimbursement_decision_junction on reimbursement_decision_junction.reimId = Reimbursements.reimId"
				+ " inner join ReimbursementDecision on ReimbursementDecision.decisionId = reimbursement_decision_junction.decisionId"
				+ " Where ReimbursementDecision.decisionId = 2";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);	
		ResultSet resset = preparedStatement.executeQuery();

		while(resset.next()) { //convert to string for user			
			jdbcReimbursementTicket ticket = new jdbcReimbursementTicket();
			ticket.setAmount(resset.getDouble(1));
			ticket.setDescription(resset.getString(2));
			ticket.setTimeStamp(resset.getDate(3));
			ticket.setType(resset.getString(4));
			tickets.add(ticket);
		}
		return tickets;
	}
	
	public void deletePendTicket(int rejectId) throws SQLException {
		String sql = "Delete from pending_reimbursement_junction where pendId = ?";
		String sql1 = "Delete from pending_type_junction where pendId = ?";
		String sql2 = "Delete from pendingreimbursements where pendId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, rejectId);
        preparedStatement.executeUpdate();
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        preparedStatement1.setInt(1, rejectId);
        preparedStatement1.executeUpdate();
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setInt(1, rejectId);
        preparedStatement2.executeUpdate();
	}
	
	public PendingTickets getTicketById(int id) throws SQLException {
		PendingTickets pend = new PendingTickets();
		String sql = "Select * from pendingreimbursements where pendId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resset = preparedStatement.executeQuery();
        while(resset.next()) {
        	pend.setAmount(resset.getDouble(2));
        	pend.setDescription(resset.getString(3));
        	pend.setTimeStamp(resset.getDate(4));
        }
        return pend;
	}
	
	public int getEmpId(int id) throws SQLException {
		int empId = 0;
		String sql = "Select empId from pending_reimbursement_junction where pendId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resset = preparedStatement.executeQuery();
        while(resset.next()) {
        	empId = resset.getInt(1);
        }
        return empId;
	}
	
	public int getTypeId(int id) throws SQLException {
		int typeId = 0;
		String sql = "Select typeId from pending_type_junction where pendId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resset = preparedStatement.executeQuery();
        while(resset.next()) {
        	typeId = resset.getInt(1);
        }
        return typeId;
	}
	
	public int getNewTicketId() throws SQLException {
		int id = 0;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("Select max(reimId) from reimbursements");
		while (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
	}
	
	public void approveTicket(int id) throws SQLException {
		PendingTicketDAO pend = new PendingTicketDAO();
		PendingTickets pendTicket = pend.getTicketById(id);
		int empId = pend.getEmpId(id);
		int typeId = pend.getEmpId(id);
		int decisionId = 1;
		String sql = "insert into reimbursements (reimAmt, reimDescription, reimDate) values (?,?,CURRENT_DATE)";
		String sql1 = "insert into employee_reimbursement_junction (empId, reimId) values (?,?)";
		String sql2 = "insert into reimbursement_type_junction (reimId, typeId) values (?,?)";
		String sql3 = "insert into reimbursement_decision_junction (reimId, decisionId) values (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, pendTicket.getAmount());
        preparedStatement.setString(2, pendTicket.getDescription());
        preparedStatement.executeUpdate();
        int reimId = pend.getNewTicketId();
        
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        preparedStatement1.setInt(1, empId);
        preparedStatement1.setInt(2, reimId);
        preparedStatement1.executeUpdate();
        
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setInt(1, reimId);
        preparedStatement2.setInt(2, typeId);
        preparedStatement2.executeUpdate();
        
        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
        preparedStatement3.setInt(1, reimId);
        preparedStatement3.setInt(2, decisionId);
        preparedStatement3.executeUpdate();
		
        pend.deletePendTicket(id);
	}
	
	public void rejectTicket(int id) throws SQLException {
		PendingTicketDAO pend = new PendingTicketDAO();
		PendingTickets pendTicket = pend.getTicketById(id);
		int empId = pend.getEmpId(id);
		int typeId = pend.getEmpId(id);
		int decisionId = 2;
		String sql = "insert into reimbursements (reimAmt, reimDescription, reimDate) values (?,?,CURRENT_DATE)";
		String sql1 = "insert into employee_reimbursement_junction (empId, reimId) values (?,?)";
		String sql2 = "insert into reimbursement_type_junction (reimId, typeId) values (?,?)";
		String sql3 = "insert into reimbursement_decision_junction (reimId, decisionId) values (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, pendTicket.getAmount());
        preparedStatement.setString(2, pendTicket.getDescription());
        preparedStatement.executeUpdate();
        int reimId = pend.getNewTicketId();
        
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        preparedStatement1.setInt(1, empId);
        preparedStatement1.setInt(2, reimId);
        preparedStatement1.executeUpdate();
        
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setInt(1, reimId);
        preparedStatement2.setInt(2, typeId);
        preparedStatement2.executeUpdate();
        
        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
        preparedStatement3.setInt(1, reimId);
        preparedStatement3.setInt(2, decisionId);
        preparedStatement3.executeUpdate();
		
        pend.deletePendTicket(id);
	}


}
