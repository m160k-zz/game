package org.game.db.dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.game.db.domain.Question;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class QuestionDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    @Transactional
    public void persist(Question guest) {
        em.persist(guest);
    }
 
    // Retrieves all the guests:
    public List<Question> getAllQuests() {
    	TypedQuery<Question> query = em.createQuery("SELECT q FROM Question q", Question.class);
    	return query.getResultList();
    }
        
    public Question getRandomQuestion() {
    	TypedQuery<Question> query = em.createQuery("SELECT q FROM Question q order by rand() limit 1", Question.class);
    	return query.getSingleResult();
    }
    
    public Question getQuestion(Long questionId) {
    	TypedQuery<Question> query = em.createQuery("SELECT q FROM Question q WHERE q.questionId = " + questionId, Question.class);
    	return query.getSingleResult();
    }
  
}