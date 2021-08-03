package com.revature.dto;

public class CounterOfferDTO {
	
	private String poke_username;
	private int poke_id;
	
	
	public CounterOfferDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CounterOfferDTO(String poke_username, int poke_id) {
		super();
		this.poke_username = poke_username;
		this.poke_id = poke_id;
	}


	@Override
	public String toString() {
		return "CounterOfferDTO [poke_username=" + poke_username + ", poke_id=" + poke_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + poke_id;
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
		CounterOfferDTO other = (CounterOfferDTO) obj;
		if (poke_id != other.poke_id)
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


	public int getPoke_id() {
		return poke_id;
	}


	public void setPoke_id(int poke_id) {
		this.poke_id = poke_id;
	}
	
	

}
