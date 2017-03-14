package dao;

import org.hibernate.SessionFactory;

import model.Company;

import java.util.List;

public class CompanyDao extends BasicDao<Long, Company> {

	public CompanyDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}

	@Override
	public Company getById(Long key) {
		return super.getById(key);
	}


	@Override
	public void save(Company entity) {
		super.save(entity);
	}

	@Override
	public void delete(Company entity) {
		super.delete(entity);
	}

	@Override
	public Company get(String propertyName, Object value) {
		return super.get(propertyName, value);
	}


	@Override
	public List<Company> list() {
		return super.list();
	}

	@Override
	public void removeALL() {
		super.removeALL();
	}

	@Override
	public List<Company> getList(String propertyName, Object value) {
		return super.getList(propertyName, value);
	}

}
