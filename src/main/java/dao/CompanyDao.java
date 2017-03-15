package main.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CompanyDao extends BasicDao<Long, Company> {

	private SessionFactory sessionFactory ;
	private final static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);

		@Override
	    public Company getById(Long key) {
		Session session = getSession();
		session.beginTransaction();
		Company company = session.load(Company.class, key);
		session.getTransaction().commit();
		LOGGER.info("Compny: " + company + " successfully loaded.");
		session.close();
		return company;
	}


	@Override
	public void save(Company entity) {
		Session session = getSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		LOGGER.info("Compny: " + entity + " successfully save.");
		session.close();
	}

	@Override
	public void delete(Company entity) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		LOGGER.info("Compny: " + entity + " successfully delete.");
		session.close();
	}

	@Override
	public List<Company> list() {
		Session session = getSession();
		session.beginTransaction();
		List<Company> companies = new ArrayList<>(session.createQuery("select d from Comapany d").list());
	    session.getTransaction().commit();
		return companies;
	}


	@Override
	public void removeALL() {
		Session session = getSession();
		session.beginTransaction();
		session.createQuery("delete from Company").executeUpdate();
		super.removeALL();
	}

	public void update(Company company){
		Session session = getSession();
		session.beginTransaction();
		Company companyToUpdate = getById(company.getId());
		companyToUpdate.setName(company.getName());
		session.getTransaction().commit();
		LOGGER.info("Company : " + company + " successfully updated.");
		session.close();
	}

}
