package main.java.dao;

import org.hibernate.SessionFactory;

import main.java.model.Project;

import java.util.List;

public class ProjectDao extends BasicDao<Long, Project> {
	public ProjectDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}

	@Override
	public Project getById(Long key) {
		return super.getById(key);
	}

	@Override
	public void save(Project entity) {
		super.save(entity);
	}

	@Override
	public void delete(Project entity) {
		super.delete(entity);
	}

	@Override
	public Project get(String propertyName, Object value) {
		return super.get(propertyName, value);
	}

	@Override
	public List<Project> list() {
		return super.list();
	}

	@Override
	public List<Project> getList(String propertyName, Object value) {
		return super.getList(propertyName, value);
	}
}
