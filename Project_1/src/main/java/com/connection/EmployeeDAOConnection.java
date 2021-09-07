package com.connection;

import com.DAO.EmployeesDAO;

public class EmployeeDAOConnection {
	
	private static EmployeesDAO dao;
	
	private EmployeeDAOConnection() {}
	
	public static EmployeesDAO getEmployeesDAO() {
        if(dao == null)
            dao = new EmployeesDAO();
        return dao;
    }

}