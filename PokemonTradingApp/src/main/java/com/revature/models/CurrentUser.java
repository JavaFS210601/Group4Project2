package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "current_user")
public class CurrentUser {
	
	@Column(name = "poke_username")
	private String poke_username;
	
	@Id
	@Column(name = "poke_user_id")
	private int poke_user_id;

	
	
	
	public CurrentUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentUser(String poke_username, int poke_user_id) {
		super();
		this.poke_username = poke_username;
		this.poke_user_id = poke_user_id;
	}

	@Override
	public String toString() {
		return "CurrentUser [poke_username=" + poke_username + ", poke_user_id=" + poke_user_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + poke_user_id;
		result = prime * result + ((poke_username == null) ? 0 : poke_username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrentUser other = (CurrentUser) obj;
		if (poke_user_id != other.poke_user_id)
			return false;
		if (poke_username == null) {
			if (other.poke_username != null)
				return false;
		} else if (!poke_username.equals(other.poke_username))
			return false;
		return true;
	}

	public String getPoke_username() {
		return poke_username;
	}

	public void setPoke_username(String poke_username) {
		this.poke_username = poke_username;
	}

	public int getPoke_user_id() {
		return poke_user_id;
	}

	public void setPoke_user_id(int poke_user_id) {
		this.poke_user_id = poke_user_id;
	}
	
	

}
