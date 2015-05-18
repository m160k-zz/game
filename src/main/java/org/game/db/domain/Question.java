package org.game.db.domain;
 
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
 
@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id 
    @GeneratedValue
    @Column(name = "questionId")
    Long questionId;
    private String value;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
	@JsonManagedReference
    private Collection<Answer> answers;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId")
    @JsonBackReference
	private User user;
	
	    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question() {
    }
 
    public Question(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
    	String res = value + "<br>";
    	for(Answer ans : answers) {
    		res += "- " + ans + "<br>";
    	}
        return res;
    }
 
    public Collection<Answer> getAnswers() {
		return answers;
	}
    
	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}