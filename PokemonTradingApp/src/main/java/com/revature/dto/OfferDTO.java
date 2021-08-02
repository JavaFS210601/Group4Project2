package com.revature.dto;

public class OfferDTO {

	private int inventory_id;
	private int poke_id;
	
	
	
	
	public OfferDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OfferDTO(int inventory_id, int poke_id) {
		super();
		this.inventory_id = inventory_id;
		this.poke_id = poke_id;
	}

	public OfferDTO(int poke_id) {
		super();
		this.poke_id = poke_id;
	}

	@Override
	public String toString() {
		return "OfferDTO [inventory_id=" + inventory_id + ", poke_id=" + poke_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inventory_id;
		result = prime * result + poke_id;
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
		OfferDTO other = (OfferDTO) obj;
		if (inventory_id != other.inventory_id)
			return false;
		if (poke_id != other.poke_id)
			return false;
		return true;
	}

	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public int getPoke_id() {
		return poke_id;
	}

	public void setPoke_id(int poke_id) {
		this.poke_id = poke_id;
	}


}
