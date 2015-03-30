package org.game.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.game.db.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDao {
	// Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    @Transactional
    public void persist(User guest) {
        em.persist(guest);
    }
    
    // Retrieves all the users:
    public List<User> getAllUsers() {
    	TypedQuery<User> query = em.createQuery("SELECT u FROM user u", User.class);
    	return query.getResultList();
    }
}
