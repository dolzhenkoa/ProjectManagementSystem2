package main.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.model.Skill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SkillDao extends BasicDao<Long, Skill> {
    public SkillDao(SessionFactory sessionFactory) {
        setSession(sessionFactory);
    }


    private final static Logger LOGGER = LoggerFactory.getLogger(SkillDao.class);

    public Skill load(Long id) {
        Session session = getSession();
        session.beginTransaction();
        Skill skill = (Skill) session.createQuery("select s from Skill s where id=" + id).uniqueResult();
        session.getTransaction().commit();
        LOGGER.info("Skill: " + skill + " successfully loaded.");
        session.close();
        return skill;
    }

    public void update(Skill skill) {
        Session session = getSession();
        session.beginTransaction();
        Skill skillToUpdate = getById(skill.getId());
        skillToUpdate.setName(skill.getName());
        session.getTransaction().commit();
        LOGGER.info("Skill : " + skill + " successfully updated.");
        session.close();
    }


    public List<Skill> getAll() {
        Session session = getSession();
        session.beginTransaction();
        List<Skill> skills = new ArrayList<>(session.createQuery("select s from Skill s").list());
        session.getTransaction().commit();
        session.close();
        return skills;
    }

    @Override
    public void save(Skill entity) {
        Session session = getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        LOGGER.info("Skill : " + entity + " successfully saved to DB.");
        session.close();
    }

    @Override
    public void delete(Skill entity) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        LOGGER.info("Skill : " + entity + " successfully deleted from DB.");
        session.close();
    }

    @Override
    public void removeALL() {
        Session session = getSession();
        session.beginTransaction();
        session.createQuery("delete from Skill");
        session.getTransaction().commit();
        LOGGER.info("All skills were deleted from DB.");
        session.close();
    }
}

