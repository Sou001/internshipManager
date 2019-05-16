package org.melsif.dao;

import org.melsif.model.Skill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SkillDao {

    private static SkillDao instance;
    private EntityManager entityManager;

    private SkillDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("internship-pu");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static SkillDao getInstance() {
        if (instance == null) {
            instance = new SkillDao();
        }
        return instance;
    }


    public List<Skill> findAll() {
        return entityManager.createQuery("FROM " + Skill.class.getName()).getResultList();
    }

    public void persist(Skill skill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(skill);
            entityManager.getTransaction().commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public Skill getById(Integer id) {
        return entityManager.find(Skill.class, id);
    }

    public void merge(Skill skill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(skill);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Skill skill) {
        try {
            entityManager.getTransaction().begin();
            skill = entityManager.find(Skill.class, skill.getId());
            entityManager.remove(skill);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(); entityManager.getTransaction().rollback();
        }
    }

    public void removeById(Integer id) {
        try {
            Skill skill = getById(id);
            remove(skill);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
