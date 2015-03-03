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
    
    @OneToMany(mappedBy = "question")
    private Collection<Answer> answers;
 
    public Collection<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}

	public Question() {
    }
 
    public Question(String value) {
        this.value = value;
    }
 
}