package com.connection;

import com.DAO.PendingTicketDAO;

public class PendingTicketDAOConnection {
	
	private static PendingTicketDAO dao;
	
	private PendingTicketDAOConnection() {}
	
	public static PendingTicketDAO getPendingTicketDAO() {
        if(dao == null)
            dao = new PendingTicketDAO();
        return dao;
    }

}
