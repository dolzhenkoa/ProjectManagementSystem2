package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Company;

public class CompanyDao extends BasicDao<Long, Company> {
	public CompanyDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
	
	@Override
	public void update(Company company) {
		Transaction	tx = getSession().beginTransaction();
		Company entity = getSession().get(Company.class, company.getId());
		if(entity!=null){
			entity.setName(company.getName());
		}
		tx.commit();
	}

}
