package com.ticket.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
	public static SessionFactory factory;
	
	public static SessionFactory getFactory(){
		if(factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}

	public void closeFunction(){
		if (factory.isOpen()) {
			factory.close();
		}
	}
}
