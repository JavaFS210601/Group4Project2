package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.daos.OfferPoolDAO;
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

}
