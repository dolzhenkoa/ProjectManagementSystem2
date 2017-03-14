package dao;

import org.hibernate.SessionFactory;

import model.Company;

public class CompanyDao extends BasicDao<Long, Company> {

	public CompanyDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
}
