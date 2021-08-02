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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "offer_pool")
public class OfferPool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offer_pool_id")
	private int offer_pool_id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "primary_inventory_id")
	private InventoryJoin primary_inventory_id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reply_inventory__id")
	private InventoryJoin reply_inventory_id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_status_id") //specify which author column to create a relationship on
	private OfferStatus offer_status_id;

	
	//Boiler Plate Code --------------------------------------------------------------------------------
	
	public OfferPool() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OfferPool(int offer_pool_id, InventoryJoin primary_inventory_id, InventoryJoin reply_inventory_id,
			OfferStatus offer_status_id) {
		super();
		this.offer_pool_id = offer_pool_id;
		this.primary_inventory_id = primary_inventory_id;
		this.reply_inventory_id = reply_inventory_id;
		this.offer_status_id = offer_status_id;
	}


	public OfferPool(InventoryJoin primary_inventory_id, InventoryJoin reply_inventory_id,
			OfferStatus offer_status_id) {
		super();
		this.primary_inventory_id = primary_inventory_id;
		this.reply_inventory_id = reply_inventory_id;
		this.offer_status_id = offer_status_id;
	}


	@Override
	public String toString() {
		return "OfferPool [offer_pool_id=" + offer_pool_id + ", primary_inventory_id=" + primary_inventory_id
				+ ", reply_inventory_id=" + reply_inventory_id + ", offer_status_id=" + offer_status_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offer_pool_id;
		result = prime * result + ((offer_status_id == null) ? 0 : offer_status_id.hashCode());
		result = prime * result + ((primary_inventory_id == null) ? 0 : primary_inventory_id.hashCode());
		result = prime * result + ((reply_inventory_id == null) ? 0 : reply_inventory_id.hashCode());
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
		OfferPool other = (OfferPool) obj;
		if (offer_pool_id != other.offer_pool_id)
			return false;
		if (offer_status_id == null) {
			if (other.offer_status_id != null)
				return false;
		} else if (!offer_status_id.equals(other.offer_status_id))
			return false;
		if (primary_inventory_id == null) {
			if (other.primary_inventory_id != null)
				return false;
		} else if (!primary_inventory_id.equals(other.primary_inventory_id))
			return false;
		if (reply_inventory_id == null) {
			if (other.reply_inventory_id != null)
				return false;
		} else if (!reply_inventory_id.equals(other.reply_inventory_id))
			return false;
		return true;
	}


	public int getOffer_pool_id() {
		return offer_pool_id;
	}


	public void setOffer_pool_id(int offer_pool_id) {
		this.offer_pool_id = offer_pool_id;
	}


	public InventoryJoin getPrimary_inventory_id() {
		return primary_inventory_id;
	}


	public void setPrimary_inventory_id(InventoryJoin primary_inventory_id) {
		this.primary_inventory_id = primary_inventory_id;
	}


	public InventoryJoin getReply_inventory_id() {
		return reply_inventory_id;
	}


	public void setReply_inventory_id(InventoryJoin reply_inventory_id) {
		this.reply_inventory_id = reply_inventory_id;
	}


	public OfferStatus getOffer_status_id() {
		return offer_status_id;
	}


	public void setOffer_status_id(OfferStatus offer_status_id) {
		this.offer_status_id = offer_status_id;
	}


	
}
