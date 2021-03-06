package com.revature.daos;

import java.util.List;

import com.revature.models.InventoryJoin;
import com.revature.models.OfferPool;
import com.revature.models.PokeUsers;

public interface OfferPoolDAOInterface {
	
	public List<OfferPool> getAllOffers();
	
	public OfferPool getOfferByID(int findID);
	
	public List<OfferPool> getOffersByUser(PokeUsers user);
	
	public void setOfferStatus(OfferPool offer, OfferPool newStatus);
	
	public boolean newOffer(OfferPool addOffer);
	
	public boolean replyOffer(OfferPool addToOffer, InventoryJoin replyOffer);
	
	public List<OfferPool> getOffersByStatus(int offerStatus);
	
	public void cancelOffer(OfferPool deleteThis);
	
	
	
	//OFFER UPDATES
	public void updateOffer(OfferPool offer);
	
	public void updateOfferPending(OfferPool offerP);
	
	public void updateOfferComplete(OfferPool offerC);
	

}
