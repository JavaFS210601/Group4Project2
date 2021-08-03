package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.OfferPoolDAO;
import com.revature.dto.ReplyOfferDTO;
import com.revature.models.InventoryJoin;
import com.revature.models.OfferPool;

@Service
public class OfferService {

	public boolean newOffer(OfferPool offerPool) {

		OfferPoolDAO offerDao = new OfferPoolDAO();
		
		if(offerDao.newOffer(offerPool)) {
			return true;
		}
		
		return false;
	}

	public List<OfferPool> getOffer() {

		OfferPoolDAO offerDao = new OfferPoolDAO();
		

		 List<OfferPool> offer =offerDao.getAllOffers();


		return offer;
	}
	
	public boolean replyOffer(ReplyOfferDTO replyOffer) {
		
		OfferPoolDAO offerDao = new OfferPoolDAO();
		OfferPool offerPool = offerDao.getOfferByID(replyOffer.getOffer_id());
		InventoryJoin inventory = replyOffer.getInventory();
		
		if(offerDao.replyOffer(offerPool, inventory)) {
			return true;
		}
		
//		UserDAO userDao = new UserDAO();
//		
//		String username = counter.getPoke_username();
//		PokeUsers user = userDao.getUserByUsername(username);
//		
//		int user_id = user.getPoke_user_id();
		
		return false;		
		
		
	}

}
