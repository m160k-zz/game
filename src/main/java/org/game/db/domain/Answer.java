package org.game.db.domain;
 
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Entity
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id @GeneratedValue
    Long answerId;
    private String value;
    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private Long isCorrect;
    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;
 
    public Answer() {
    }
 
    public Answer(String value, Long isCorrect) {
        this.value = value;
        this.isCorrect = isCorrect;
    }
 
    @Override
    public String toString() {
    	return value;
    }
    
}