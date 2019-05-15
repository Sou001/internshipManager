package org.melsif.dao;

import org.melsif.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDao {

    private static UserDao instance;
    private EntityManager entityManager;

    private UserDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("internship-pu");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public User getByEmail(String email) {
        return entityManager.find(User.class, email);
    }

    public List<User> findAll() {
        return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
    }

    public void persist(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(User user) {
        try {
            entityManager.getTransaction().begin();
            user = entityManager.find(User.class, user.getEmail());
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(); entityManager.getTransaction().rollback();
        }
    }

    public void removeById(String email) {
        try {
            User user = getByEmail(email);
            remove(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
