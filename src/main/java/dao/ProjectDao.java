package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Project;

public class ProjectDao extends BasicDao<Long, Project> {
	public ProjectDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}

	public void update(Project project) {
		Transaction	tx = getSession().beginTransaction();
		Project entity = getSession().get(Project.class, project.getId());
		if(entity!=null){
			entity.setName(project.getName());
		}
		tx.commit();
	}
}
