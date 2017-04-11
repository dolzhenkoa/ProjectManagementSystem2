package dao;

import model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDao extends BasicDao<Long, Customer> {
	
	public CustomerDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}

	public void update(Customer customer) {
		Transaction	tx = getSession().beginTransaction();
		Customer entity = getSession().get(Customer.class, customer.getId());
		if(entity!=null){
			entity.setName(customer.getName());
		}
		tx.commit();
	}

}
