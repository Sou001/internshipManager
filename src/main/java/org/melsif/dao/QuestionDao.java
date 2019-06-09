package org.melsif.dao;

import org.melsif.model.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import org.hibernate.Session;

public class QuestionDao {

    private static QuestionDao instance;
    private EntityManager entityManager;

    private QuestionDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("internship-pu");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static QuestionDao getInstance() {
        if (instance == null) {
            instance = new QuestionDao();
        }
        return instance;
    }

    public Question getById(Integer id) {
        return entityManager.find(Question.class, id);
    }
    
    public Question getByTitle(String title) {
        Session session = entityManager.unwrap( Session.class );
        Question question = session.bySimpleNaturalId(Question.class)
                .load( title );
        return question;
    }

    public List<Question> findAll() {
        return entityManager.createQuery("FROM " + Question.class.getName()).getResultList();
    }

    public void persist(Question question) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(question);
            entityManager.getTransaction().commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Question question) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(question);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Question question) {
        try {
            entityManager.getTransaction().begin();
            question = entityManager.find(Question.class, question.getId());
            entityManager.remove(question);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(); entityManager.getTransaction().rollback();
        }
    }

    public void removeById(Integer id) {
        try {
            Question question = getById(id);
            remove(question);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
