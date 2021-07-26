package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pokeUsers")
public class PokeUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poke_user_id")
	private int poke_user_id;
	
	@Column(name = "poke_username")
	private String poke_username;
	
	@Column(name = "poke_password")
	private String poke_password;
	
	@Column(name = "poke_full_name")
	private String poke_full_name;
	
	@Column(name = "poke_contact_info")
	private String poke_contact_info;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_id") //specify which author column to create a relationship on
	private OfferPool offerPool;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_id") //specify which author column to create a relationship on
	private InventoryJoin inventoryJoin;

	
	//Boiler Plate Code --------------------------------------------------------------------------------
	
	public PokeUsers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PokeUsers(int poke_user_id, String poke_username, String poke_password, String poke_full_name,
			String poke_contact_info, OfferPool offerPool, InventoryJoin inventoryJoin) {
		super();
		this.poke_user_id = poke_user_id;
		this.poke_username = poke_username;
		this.poke_password = poke_password;
		this.poke_full_name = poke_full_name;
		this.poke_contact_info = poke_contact_info;
		this.offerPool = offerPool;
		this.inventoryJoin = inventoryJoin;
	}


	public PokeUsers(String poke_username, String poke_password, String poke_full_name, String poke_contact_info,
			OfferPool offerPool, InventoryJoin inventoryJoin) {
		super();
		this.poke_username = poke_username;
		this.poke_password = poke_password;
		this.poke_full_name = poke_full_name;
		this.poke_contact_info = poke_contact_info;
		this.offerPool = offerPool;
		this.inventoryJoin = inventoryJoin;
	}


	@Override
	public String toString() {
		return "PokeUsers [poke_user_id=" + poke_user_id + ", poke_username=" + poke_username + ", poke_password="
				+ poke_password + ", poke_full_name=" + poke_full_name + ", poke_contact_info=" + poke_contact_info
				+ ", offerPool=" + offerPool + ", inventoryJoin=" + inventoryJoin + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventoryJoin == null) ? 0 : inventoryJoin.hashCode());
		result = prime * result + ((offerPool == null) ? 0 : offerPool.hashCode());
		result = prime * result + ((poke_contact_info == null) ? 0 : poke_contact_info.hashCode());
		result = prime * result + ((poke_full_name == null) ? 0 : poke_full_name.hashCode());
		result = prime * result + ((poke_password == null) ? 0 : poke_password.hashCode());
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
		PokeUsers other = (PokeUsers) obj;
		if (inventoryJoin == null) {
			if (other.inventoryJoin != null)
				return false;
		} else if (!inventoryJoin.equals(other.inventoryJoin))
			return false;
		if (offerPool == null) {
			if (other.offerPool != null)
				return false;
		} else if (!offerPool.equals(other.offerPool))
			return false;
		if (poke_contact_info == null) {
			if (other.poke_contact_info != null)
				return false;
		} else if (!poke_contact_info.equals(other.poke_contact_info))
			return false;
		if (poke_full_name == null) {
			if (other.poke_full_name != null)
				return false;
		} else if (!poke_full_name.equals(other.poke_full_name))
			return false;
		if (poke_password == null) {
			if (other.poke_password != null)
				return false;
		} else if (!poke_password.equals(other.poke_password))
			return false;
		if (poke_user_id != other.poke_user_id)
			return false;
		if (poke_username == null) {
			if (other.poke_username != null)
				return false;
		} else if (!poke_username.equals(other.poke_username))
			return false;
		return true;
	}


	public int getPoke_user_id() {
		return poke_user_id;
	}


	public void setPoke_user_id(int poke_user_id) {
		this.poke_user_id = poke_user_id;
	}


	public String getPoke_username() {
		return poke_username;
	}


	public void setPoke_username(String poke_username) {
		this.poke_username = poke_username;
	}


	public String getPoke_password() {
		return poke_password;
	}


	public void setPoke_password(String poke_password) {
		this.poke_password = poke_password;
	}


	public String getPoke_full_name() {
		return poke_full_name;
	}


	public void setPoke_full_name(String poke_full_name) {
		this.poke_full_name = poke_full_name;
	}


	public String getPoke_contact_info() {
		return poke_contact_info;
	}


	public void setPoke_contact_info(String poke_contact_info) {
		this.poke_contact_info = poke_contact_info;
	}


	public OfferPool getOfferPool() {
		return offerPool;
	}


	public void setOfferPool(OfferPool offerPool) {
		this.offerPool = offerPool;
	}


	public InventoryJoin getInventoryJoin() {
		return inventoryJoin;
	}


	public void setInventoryJoin(InventoryJoin inventoryJoin) {
		this.inventoryJoin = inventoryJoin;
	}
	

}
