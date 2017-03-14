package main.java.dao;

import org.hibernate.SessionFactory;

import main.java.model.Skill;

public class SkillDao extends BasicDao<Long, Skill> {
	public SkillDao(SessionFactory sessionFactory) {
		setSession(sessionFactory);
	}
}
