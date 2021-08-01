package com.revature.dto;

import com.revature.models.PokeStatus;

public class InventoryDTO {

	private int inventory_id;
	private String poke_username;
	private int poke_id_fk;
	private PokeStatus poke_status_id;
	public InventoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InventoryDTO(int inventory_id, String poke_username, int poke_id_fk, PokeStatus poke_status_id) {
		super();
		this.inventory_id = inventory_id;
		this.poke_username = poke_username;
		this.poke_id_fk = poke_id_fk;
		this.poke_status_id = poke_status_id;
	}
	public InventoryDTO(String poke_username, int poke_id_fk, PokeStatus poke_status_id) {
		super();
		this.poke_username = poke_username;
		this.poke_id_fk = poke_id_fk;
		this.poke_status_id = poke_status_id;
	}
	
	public InventoryDTO(String poke_username, int poke_id_fk) {
		super();
		this.poke_username = poke_username;
		this.poke_id_fk = poke_id_fk;
	}
	
	
	@Override
	public String toString() {
		return "InventoryDTO [inventory_id=" + inventory_id + ", poke_username=" + poke_username + ", poke_id_fk="
				+ poke_id_fk + ", poke_status_id=" + poke_status_id + "]";
	}
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public String getPoke_username() {
		return poke_username;
	}
	public void setPoke_username(String poke_username) {
		this.poke_username = poke_username;
	}
	public int getPoke_id_fk() {
		return poke_id_fk;
	}
	public void setPoke_id_fk(int poke_id_fk) {
		this.poke_id_fk = poke_id_fk;
	}
	public PokeStatus getPoke_status_id() {
		return poke_status_id;
	}
	public void setPoke_status_id(PokeStatus poke_status_id) {
		this.poke_status_id = poke_status_id;
	}
	
	
}
