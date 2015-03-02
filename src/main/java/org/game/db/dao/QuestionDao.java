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
    public List<Question> getAllGuests() {
    	TypedQuery<Question> query = em.createQuery(
            "SELECT g FROM Guest g ORDER BY g.id", Question.class);
    	return query.getResultList();
    }
}