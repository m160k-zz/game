package org.game.db.domain;
 
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
@Entity
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id 
    @GeneratedValue
    Long answerId;
    private String value;
	private Long isCorrect;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "questionId")
    private Question question;
 
    public Answer() {
    }
 
    public Answer(Question question, String value, Long isCorrect) {
        this.question = question;
    	this.value = value;
        this.isCorrect = isCorrect;
    }
 
    @Override
    public String toString() {
    	return value;
    }
    
    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Long isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
    
}