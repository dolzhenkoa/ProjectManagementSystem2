package main.java.dao;

import org.hibernate.SessionFactory;

import main.java.model.Developer;

public class DeveloperDao extends BasicDao<Long, Developer> {
	
	public DeveloperDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}

	public void update(Developer newDeveloper) {
		
		
	}
}
