package main.java.dao;

import main.java.model.Customer;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerDao extends BasicDao<Long, Customer> {
	
	public CustomerDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}

	@Override
	public Customer getById(Long key) {
		return super.getById(key);
	}

	@Override
	public void save(Customer entity) {
		super.save(entity);
	}

	@Override
	public void delete(Customer entity) {
		super.delete(entity);
	}

	@Override
	public Customer get(String propertyName, Object value) {
		return super.get(propertyName, value);
	}

	@Override
	public List<Customer> list() {
		return super.list();
	}

	@Override
	public void removeALL() {
		super.removeALL();
	}

	@Override
	public List<Customer> getList(String propertyName, Object value) {
		return super.getList(propertyName, value);
	}
}
