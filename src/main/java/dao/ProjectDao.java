package main.java.dao;

import org.hibernate.SessionFactory;

import main.java.model.Project;

public class ProjectDao extends BasicDao<Long, Project> {
	public ProjectDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
}
