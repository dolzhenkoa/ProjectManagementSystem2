package main.java.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProjectDao extends BasicDao<Long, Project> {
	public ProjectDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
	private final static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);

	@Override
	public Project getById(Long key) {
		Session session = getSession();
		session.beginTransaction();
		Project project = session.load(Project.class, key);
		session.getTransaction().commit();
		LOGGER.info("Project : " + project + " successfully loaded.");
		return project;
	}

	@Override
	public void save(Project project) {
		Session session = getSession();
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		LOGGER.info("Project : " + project + " successfully save.");
	}

	@Override
	public void delete(Project project) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(project);
		session.getTransaction().commit();
		LOGGER.info("Project : " + project + " successfully delete.");
		session.close();
	}

	@Override
	public List<Project> list() {
		Session session = getSession();
		session.beginTransaction();
		List<Project> projects = new ArrayList<>(session.createQuery("select p from Project  p").list());
		session.getTransaction().commit();
		LOGGER.info("List of Projects successfully load.");
		session.close();
		return projects;
	}

	@Override
	public void removeALL() {
		Session session = getSession();
		session.beginTransaction();
		session.createQuery("delete from Project").executeUpdate();
		session.getTransaction().commit();
		LOGGER.info("Successfully remove all from Projects");
		session.close();
	}

	public void update(Project project){
		Session session = getSession();
		session.beginTransaction();
		Project projectToUpdate = getById(project.getId());
		projectToUpdate.setName(project.getName());
		session.getTransaction().commit();
		LOGGER.info("Project : " + project + " successfully updated.");
		session.close();
	}
}
