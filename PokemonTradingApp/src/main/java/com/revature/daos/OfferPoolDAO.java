package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.OfferPool;
import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

public class OfferPoolDAO implements OfferPoolDAOInterface{

	@Override
	public List<OfferPool> getAllOffers() {
		
		Session session = HibernateUtil.getSession();
		
		List<OfferPool> currentOffers =  session.createQuery("FROM offer_pool").list();
		HibernateUtil.closeSession();
		// TODO Auto-generated method stub
		return currentOffers;
	}

	@Override
	public OfferPool getOfferByID(int findID) {
		
		Session session = HibernateUtil.getSession();
		
		OfferPool specificOffer = (OfferPool) session.createQuery("FROM offer_pool WHERE offer_id = ?1").setParameter(1,  findID).getSingleResult();
		HibernateUtil.closeSession();
		// TODO Auto-generated method stub
		return specificOffer;
	}

	@Override
	public List<OfferPool> getOffersByUser(PokeUsers user) {
		Session session = HibernateUtil.getSession();
		
		List<OfferPool> myOffers =  session.createQuery("FROM offer_pool WHERE offer_owner = ?1").setParameter(1,  user.getPoke_user_id()).list();
		HibernateUtil.closeSession();
		
		// TODO Auto-generated method stub
		return myOffers;
	}

	@Override
	public void setOfferStatus(OfferPool offer, int newStatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OfferPool newOffer(OfferPool addOffer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void replyOffer(OfferPool addToOffer, PokeUsers user, int pokemon_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OfferPool> getOffersByStatus(int offerStatus) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSession();
		
		List<OfferPool> myOffers =  session.createQuery("FROM offer_pool WHERE offer_status_id = ?1").setParameter(1,  offerStatus).list();
		HibernateUtil.closeSession();
		
		// TODO Auto-generated method stub
		return myOffers;
		
	}

}
