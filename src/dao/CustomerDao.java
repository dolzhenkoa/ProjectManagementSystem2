package dao;

import org.hibernate.SessionFactory;

import model.Customer;

public class CustomerDao extends BasicDao<Long, Customer> {
	
	public CustomerDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
}
