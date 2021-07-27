package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventoryJoin")
public class InventoryJoin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private int inventory_id;
	
	@Column(name = "user_id_fk")
	private String user_id_fk;
	
	@Column(name = "poke_id_fk")
	private String poke_id_fk;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "poke_status_id") //specify which author column to create a relationship on
	private int poke_status_id;

	
	//Boiler Plate Code --------------------------------------------------------------------------------
	
	public InventoryJoin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InventoryJoin(int inventory_id, String user_id_fk, String poke_id_fk, int poke_status_id) {
		super();
		this.inventory_id = inventory_id;
		this.user_id_fk = user_id_fk;
		this.poke_id_fk = poke_id_fk;
		this.poke_status_id = poke_status_id;
	}


	public InventoryJoin(String user_id_fk, String poke_id_fk, int poke_status_id) {
		super();
		this.user_id_fk = user_id_fk;
		this.poke_id_fk = poke_id_fk;
		this.poke_status_id = poke_status_id;
	}


	@Override
	public String toString() {
		return "InventoryJoin [inventory_id=" + inventory_id + ", user_id_fk=" + user_id_fk + ", poke_id_fk="
				+ poke_id_fk + ", poke_status_id=" + poke_status_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inventory_id;
		result = prime * result + ((poke_id_fk == null) ? 0 : poke_id_fk.hashCode());
		result = prime * result + poke_status_id;
		result = prime * result + ((user_id_fk == null) ? 0 : user_id_fk.hashCode());
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
		InventoryJoin other = (InventoryJoin) obj;
		if (inventory_id != other.inventory_id)
			return false;
		if (poke_id_fk == null) {
			if (other.poke_id_fk != null)
				return false;
		} else if (!poke_id_fk.equals(other.poke_id_fk))
			return false;
		if (poke_status_id != other.poke_status_id)
			return false;
		if (user_id_fk == null) {
			if (other.user_id_fk != null)
				return false;
		} else if (!user_id_fk.equals(other.user_id_fk))
			return false;
		return true;
	}


	public int getInventory_id() {
		return inventory_id;
	}


	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}


	public String getUser_id_fk() {
		return user_id_fk;
	}


	public void setUser_id_fk(String user_id_fk) {
		this.user_id_fk = user_id_fk;
	}


	public String getPoke_id_fk() {
		return poke_id_fk;
	}


	public void setPoke_id_fk(String poke_id_fk) {
		this.poke_id_fk = poke_id_fk;
	}


	public int getPoke_status_id() {
		return poke_status_id;
	}


	public void setPoke_status_id(int poke_status_id) {
		this.poke_status_id = poke_status_id;
	}



}
