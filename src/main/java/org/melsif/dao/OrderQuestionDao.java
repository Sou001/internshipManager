package org.melsif.dao;

import org.melsif.model.OrderQuestion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OrderQuestionDao {

    private static OrderQuestionDao instance;
    private EntityManager entityManager;

    private OrderQuestionDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("internship-pu");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static OrderQuestionDao getInstance() {
        if (instance == null) {
            instance = new OrderQuestionDao();
        }
        return instance;
    }

    public OrderQuestion getById(Integer id) {
        return entityManager.find(OrderQuestion.class, id);
    }

    public List<OrderQuestion> findAll() {
        return entityManager.createQuery("FROM " + OrderQuestion.class.getName()).getResultList();
    }

    public void persist(OrderQuestion order) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(OrderQuestion order) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(order);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(OrderQuestion order) {
        try {
            entityManager.getTransaction().begin();
            order = entityManager.find(OrderQuestion.class, order.getId());
            entityManager.remove(order);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(); entityManager.getTransaction().rollback();
        }
    }

    public void removeById(Integer id) {
        try {
            OrderQuestion order = getById(id);
            remove(order);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
