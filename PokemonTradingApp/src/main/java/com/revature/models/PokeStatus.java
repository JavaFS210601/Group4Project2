package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pokeStatus")
public class PokeStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poke_status_id")
	private int poke_status_id;
	
	@Column(name = "poke_status")
	private String poke_status;

	
	//Boiler Plate Code --------------------------------------------------------------------------------
	
	public PokeStatus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PokeStatus(int poke_status_id, String poke_status) {
		super();
		this.poke_status_id = poke_status_id;
		this.poke_status = poke_status;
	}


	public PokeStatus(String poke_status) {
		super();
		this.poke_status = poke_status;
	}


	@Override
	public String toString() {
		return "PokeStatus [poke_status_id=" + poke_status_id + ", poke_status=" + poke_status + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poke_status == null) ? 0 : poke_status.hashCode());
		result = prime * result + poke_status_id;
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
		PokeStatus other = (PokeStatus) obj;
		if (poke_status == null) {
			if (other.poke_status != null)
				return false;
		} else if (!poke_status.equals(other.poke_status))
			return false;
		if (poke_status_id != other.poke_status_id)
			return false;
		return true;
	}


	public int getPoke_status_id() {
		return poke_status_id;
	}


	public void setPoke_status_id(int poke_status_id) {
		this.poke_status_id = poke_status_id;
	}


	public String getPoke_status() {
		return poke_status;
	}


	public void setPoke_status(String poke_status) {
		this.poke_status = poke_status;
	}
	
	
	
}
