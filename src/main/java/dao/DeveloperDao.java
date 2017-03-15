package main.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.model.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DeveloperDao extends BasicDao<Long, Developer> {

    public DeveloperDao(SessionFactory sessionFactory) {
        setSession(sessionFactory);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DeveloperDao.class);

    public Developer load(Integer id) {
        Session session = getSession();
        session.beginTransaction();
        Developer developer = (Developer) session.createQuery("select d from Developer d where id=" + id).uniqueResult();
        session.getTransaction().commit();
        LOGGER.info("Developer: " + developer + " successfully loaded.");
        session.close();
        return developer;
    }

    public List<Developer> getAll(){
        Session session = getSession();
        session.beginTransaction();
        List<Developer> developers = new ArrayList<>(session.createQuery("select d from Developer d").list());
        session.getTransaction().commit();
        session.close();
        return developers;
    }

    @Override
    public void removeALL() {
        Session session = getSession();
        session.beginTransaction();
        session.createQuery("delete from Developer ");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void save(Developer entity) {
        Session session = getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        LOGGER.info("Developer : " + entity + " successfully saved to DB.");
        session.close();
    }

    public void update(Developer developer) {
        Session session = getSession();
        session.beginTransaction();
        Developer developerToUpdate = getById(developer.getId());
        developerToUpdate.setName(developer.getName());
        developerToUpdate.setAge(developer.getAge());
        developerToUpdate.setCity(developer.getCity());
        developerToUpdate.setCountry(developer.getCountry());
        developerToUpdate.setJoinDate(developer.getJoinDate());
        developerToUpdate.setSalary(developer.getSalary());
        developerToUpdate.setSkills(developer.getSkills());
        session.getTransaction().commit();
        LOGGER.info("Developer : " + developer + " successfully updated.");
        session.close();
    }
}
