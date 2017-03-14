package dao;

import org.hibernate.SessionFactory;

import model.Skill;

public class SkillDao extends BasicDao<Long, Skill> {
	public SkillDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
}
