package org.game.db.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "userId")
	Long userId;
	
	public boolean equals(Object obj) {
		User tmpUsr = (User)obj;
		if(tmpUsr.username.equals(this.username) && tmpUsr.password.equals(this.password)) {
			return true;
		} else {
			return false;
		}
    }
	
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Collection<Question> question;
	
	private String username;
	private String password;
	public Collection<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Collection<Question> question) {
		this.question = question;
	}

	
	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
