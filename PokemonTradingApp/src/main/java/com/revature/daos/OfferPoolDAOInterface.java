package com.revature.daos;

import java.util.List;

import com.revature.models.OfferPool;
import com.revature.models.PokeUsers;

public interface OfferPoolDAOInterface {
	
	public List<OfferPool> getAllOffers();
	
	public OfferPool getOfferByID(int findID);
	
	public List<OfferPool> getOffersByUser(PokeUsers user);
	
	public void setOfferStatus(OfferPool offer, int newStatus);
	
	public OfferPool newOffer(OfferPool addOffer);
	
	public void replyOffer(OfferPool addToOffer, PokeUsers user, int pokemon_id);
	
	public List<OfferPool> getOffersByStatus(int offerStatus);
	

}
