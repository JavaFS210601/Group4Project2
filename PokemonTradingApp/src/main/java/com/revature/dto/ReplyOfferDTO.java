package com.revature.dto;

import com.revature.models.InventoryJoin;

public class ReplyOfferDTO {
	
	private int offer_id;
	private InventoryJoin inventory;
	
	public ReplyOfferDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReplyOfferDTO(int offer_id, InventoryJoin inventory) {
		super();
		this.offer_id = offer_id;
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "ReplyOfferDTO [offer_id=" + offer_id + ", inventory=" + inventory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + offer_id;
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
		ReplyOfferDTO other = (ReplyOfferDTO) obj;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (offer_id != other.offer_id)
			return false;
		return true;
	}

	public int getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}

	public InventoryJoin getInventory() {
		return inventory;
	}

	public void setInventory(InventoryJoin inventory) {
		this.inventory = inventory;
	}
	
	

}
