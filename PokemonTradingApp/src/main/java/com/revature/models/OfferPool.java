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
@Table(name = "offerPool")
public class OfferPool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offer_pool_id")
	private int offer_pool_id;
	
	@Column(name = "offer_owner")
	private int offer_owner;
	
	@Column(name = "offer_poke")
	private int offer_poke;
	
	@Column(name = "reply_owner")
	private int reply_owner;
	
	@Column(name = "reply_poke")
	private int reply_poke;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_status_id") //specify which author column to create a relationship on
	private int offer_status_id;

	
	//Boiler Plate Code --------------------------------------------------------------------------------
	
	public OfferPool() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OfferPool(int offer_pool_id, int offer_owner, int offer_poke, int reply_owner, int reply_poke,
			int offer_status_id) {
		super();
		this.offer_pool_id = offer_pool_id;
		this.offer_owner = offer_owner;
		this.offer_poke = offer_poke;
		this.reply_owner = reply_owner;
		this.reply_poke = reply_poke;
		this.offer_status_id = offer_status_id;
	}


	public OfferPool(int offer_owner, int offer_poke, int reply_owner, int reply_poke, int offer_status_id) {
		super();
		this.offer_owner = offer_owner;
		this.offer_poke = offer_poke;
		this.reply_owner = reply_owner;
		this.reply_poke = reply_poke;
		this.offer_status_id = offer_status_id;
	}


	@Override
	public String toString() {
		return "OfferPool [offer_pool_id=" + offer_pool_id + ", offer_owner=" + offer_owner + ", offer_poke="
				+ offer_poke + ", reply_owner=" + reply_owner + ", reply_poke=" + reply_poke + ", offer_status_id="
				+ offer_status_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offer_owner;
		result = prime * result + offer_poke;
		result = prime * result + offer_pool_id;
		result = prime * result + offer_status_id;
		result = prime * result + reply_owner;
		result = prime * result + reply_poke;
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
		if (offer_owner != other.offer_owner)
			return false;
		if (offer_poke != other.offer_poke)
			return false;
		if (offer_pool_id != other.offer_pool_id)
			return false;
		if (offer_status_id != other.offer_status_id)
			return false;
		if (reply_owner != other.reply_owner)
			return false;
		if (reply_poke != other.reply_poke)
			return false;
		return true;
	}


	public int getOffer_pool_id() {
		return offer_pool_id;
	}


	public void setOffer_pool_id(int offer_pool_id) {
		this.offer_pool_id = offer_pool_id;
	}


	public int getOffer_owner() {
		return offer_owner;
	}


	public void setOffer_owner(int offer_owner) {
		this.offer_owner = offer_owner;
	}


	public int getOffer_poke() {
		return offer_poke;
	}


	public void setOffer_poke(int offer_poke) {
		this.offer_poke = offer_poke;
	}


	public int getReply_owner() {
		return reply_owner;
	}


	public void setReply_owner(int reply_owner) {
		this.reply_owner = reply_owner;
	}


	public int getReply_poke() {
		return reply_poke;
	}


	public void setReply_poke(int reply_poke) {
		this.reply_poke = reply_poke;
	}


	public int getOffer_status_id() {
		return offer_status_id;
	}


	public void setOffer_status_id(int offer_status_id) {
		this.offer_status_id = offer_status_id;
	}


	
}
