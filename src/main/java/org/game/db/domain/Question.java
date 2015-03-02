package org.game.db.domain;
 
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id 
    @GeneratedValue
    Long questionId;
    
    private String value;
    
    @OneToMany(mappedBy = "project")
    private Collection<Answer> answers;
 
    public Question() {
    }
 
    public Question(String value) {
        this.value = value;
    }
 
}