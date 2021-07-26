package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offerStatus")
public class OfferStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offer_status_id")
	private int offer_status_id;
	
	@Column(name = "offer_status")
	private String offer_status;

	
	//Boiler Plate Code --------------------------------------------------------------------------------
	
	public OfferStatus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OfferStatus(int offer_status_id, String offer_status) {
		super();
		this.offer_status_id = offer_status_id;
		this.offer_status = offer_status;
	}


	public OfferStatus(String offer_status) {
		super();
		this.offer_status = offer_status;
	}


	@Override
	public String toString() {
		return "OfferStatus [offer_status_id=" + offer_status_id + ", offer_status=" + offer_status + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offer_status == null) ? 0 : offer_status.hashCode());
		result = prime * result + offer_status_id;
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
		OfferStatus other = (OfferStatus) obj;
		if (offer_status == null) {
			if (other.offer_status != null)
				return false;
		} else if (!offer_status.equals(other.offer_status))
			return false;
		if (offer_status_id != other.offer_status_id)
			return false;
		return true;
	}


	public int getOffer_status_id() {
		return offer_status_id;
	}


	public void setOffer_status_id(int offer_status_id) {
		this.offer_status_id = offer_status_id;
	}


	public String getOffer_status() {
		return offer_status;
	}


	public void setOffer_status(String offer_status) {
		this.offer_status = offer_status;
	}

	
	
}
