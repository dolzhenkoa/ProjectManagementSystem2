package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Skill;

public class SkillDao extends BasicDao<Long, Skill> {
    public SkillDao(SessionFactory sessionFactory) {
        setSession(sessionFactory);
    }

	public void update(Skill skill) {
		Transaction	tx = getSession().beginTransaction();
		Skill entity = getSession().get(Skill.class, skill.getId());
		if(entity!=null){
			entity.setDescription(skill.getDescription());
		}
		tx.commit();
	}
}

