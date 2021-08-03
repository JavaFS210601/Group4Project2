package com.revature.services;

import java.util.List;

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

	public List<OfferPool> getOffer() {

		OfferPoolDAO offerDao = new OfferPoolDAO();
		
		List<OfferPool> offer = offerDao.getAllOffers();

		return offer;
	}

}
