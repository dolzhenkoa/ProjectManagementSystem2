package dao;

import org.hibernate.SessionFactory;

import model.Project;

public class ProjectDao extends BasicDao<Long, Project> {
	public ProjectDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
}
