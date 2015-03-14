package org.game.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.game.db.domain.Answer;
import org.game.db.domain.Question;
import org.springframework.transaction.annotation.Transactional;

public class AnswerDao {
	 // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    @Transactional
    public void persist(Question guest) {
        em.persist(guest);
    }
 
    // Retrieves all the guests:
    public List<Question> getAllQuests() {
    	TypedQuery<Question> query = em.createQuery(
            "SELECT q FROM Question q", Question.class);
    	for(Question q : query.getResultList()) {
    		for(Answer a : q.getAnswers()) {
    			System.out.println(a.getValue());
    		}
    	}
    	return query.getResultList();
    }      
}
