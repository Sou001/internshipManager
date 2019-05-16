package org.melsif.dao;

import org.melsif.model.OrderResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OrderResponseDao {

    private static OrderResponseDao instance;
    private EntityManager entityManager;

    private OrderResponseDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("internship-pu");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static OrderResponseDao getInstance() {
        if (instance == null) {
            instance = new OrderResponseDao();
        }
        return instance;
    }

    public OrderResponse getById(Integer id) {
        return entityManager.find(OrderResponse.class, id);
    }

    public List<OrderResponse> findAll() {
        return entityManager.createQuery("FROM " + OrderResponse.class.getName()).getResultList();
    }

    public void persist(OrderResponse user) {
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

    public void merge(OrderResponse user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(OrderResponse orderResponse) {
        try {
            entityManager.getTransaction().begin();
            orderResponse = entityManager.find(OrderResponse.class, orderResponse.getId());
            entityManager.remove(orderResponse);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(); entityManager.getTransaction().rollback();
        }
    }

    public void removeById(Integer id) {
        try {
            OrderResponse user = getById(id);
            remove(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
