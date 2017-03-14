package main.java.dao;

import org.hibernate.SessionFactory;

import main.java.model.Customer;

public class CustomerDao extends BasicDao<Long, Customer> {
	
	public CustomerDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
}
