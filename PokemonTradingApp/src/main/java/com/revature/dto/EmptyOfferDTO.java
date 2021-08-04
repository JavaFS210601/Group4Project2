package com.revature.dto;

public class EmptyOfferDTO {
	private int offer_id;

	public EmptyOfferDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyOfferDTO(int offer_id) {
		super();
		this.offer_id = offer_id;
	}

	@Override
	public String toString() {
		return "EmptyOfferDTO [offer_id=" + offer_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		EmptyOfferDTO other = (EmptyOfferDTO) obj;
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
	
}
