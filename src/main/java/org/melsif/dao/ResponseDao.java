package org.melsif.dao;

import org.melsif.model.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ResponseDao {

    private static ResponseDao instance;
    private EntityManager entityManager;

    private ResponseDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("internship-pu");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static ResponseDao getInstance() {
        if (instance == null) {
            instance = new ResponseDao();
        }
        return instance;
    }

    public Response getById(Integer id) {
        return entityManager.find(Response.class, id);
    }

    public List<Response> findAll() {
        return entityManager.createQuery("FROM " + Response.class.getName()).getResultList();
    }

    public void persist(Response response) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(response);
            entityManager.getTransaction().commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Response response) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(response);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Response response) {
        try {
            entityManager.getTransaction().begin();
            response = entityManager.find(Response.class, response.getId());
            entityManager.remove(response);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(); entityManager.getTransaction().rollback();
        }
    }

    public void removeById(Integer id) {
        try {
            Response response = getById(id);
            remove(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
