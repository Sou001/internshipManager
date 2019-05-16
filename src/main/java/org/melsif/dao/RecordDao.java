package org.melsif.dao;

import org.melsif.model.Record;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RecordDao {

    private static RecordDao instance;
    private EntityManager entityManager;

    private RecordDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("internship-pu");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static RecordDao getInstance() {
        if (instance == null) {
            instance = new RecordDao();
        }
        return instance;
    }

    public RecordDao getById(Integer id) {
        return entityManager.find(RecordDao.class, id);
    }

    public List<RecordDao> findAll() {
        return entityManager.createQuery("FROM " + RecordDao.class.getName()).getResultList();
    }

    public void persist(Record record) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(record);
            entityManager.getTransaction().commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Record record) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(record);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Record record) {
        try {
            entityManager.getTransaction().begin();
            record = entityManager.find(Record.class, record.getId());
            entityManager.remove(record);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(); entityManager.getTransaction().rollback();
        }
    }

    /*public void removeById(Integer id) {
        try {
            Record record = getById(id);
            remove(record);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
}
