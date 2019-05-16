package org.melsif.dao;

import org.melsif.model.Survey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SurveyDao {

    private static SurveyDao instance;
    private EntityManager entityManager;

    private SurveyDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("internship-pu");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static SurveyDao getInstance() {
        if (instance == null) {
            instance = new SurveyDao();
        }
        return instance;
    }

    public Survey getById(Integer id) {
        return entityManager.find(Survey.class, id);
    }

    public List<Survey> findAll() {
        return entityManager.createQuery("FROM " + Survey.class.getName()).getResultList();
    }

    public void persist(Survey survey) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(survey);
            entityManager.getTransaction().commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Survey survey) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(survey);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Survey survey) {
        try {
            entityManager.getTransaction().begin();
            survey = entityManager.find(Survey.class, survey.getSurveyId());
            entityManager.remove(survey);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(); entityManager.getTransaction().rollback();
        }
    }

    public void removeById(Integer id) {
        try {
            Survey survey = getById(id);
            remove(survey);
        } catch (Exception ex) {
            System.out.println("here");
            ex.printStackTrace();
        }
    }
}
