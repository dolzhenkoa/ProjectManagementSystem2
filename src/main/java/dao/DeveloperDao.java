package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Developer;

public class DeveloperDao extends BasicDao<Long, Developer> {

    public DeveloperDao(SessionFactory sessionFactory) {
        setSession(sessionFactory);
    }

	public void update(Developer developer) {
		Transaction	tx = getSession().beginTransaction();
		Developer entity = getSession().get(Developer.class, developer.getId());
		if(entity!=null){
			entity.setName(developer.getName());
		}
		tx.commit();
	}

}
