package com.revature.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.InventoryJoin;
import com.revature.models.OfferPool;
import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

@Repository
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
		
		
		List<OfferPool> myOffers =  session.createQuery("FROM offer_pool INNER JOIN inventory_join ON offer_pool.primary_inventory_id = inventory_join.inventory_id WHERE user_id_fk = ?1").setParameter(1,  user.getPoke_user_id()).list();
		HibernateUtil.closeSession();
		
		// TODO Auto-generated method stub
		return myOffers;
	}

	@Override
	public void setOfferStatus(OfferPool offer, OfferPool newStatus) {
		Session session = HibernateUtil.getSession();
		//offer.setStatus_status_id(newStatus);
	
		Query q = session.createQuery("UPDATE offer_pool SET offer_status_id = ?1 WHERE offer_pool_id = ?2").setParameter(1,  newStatus).setParameter(2, offer.getOffer_pool_id());
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public boolean newOffer(OfferPool addOffer) {

		Session session = HibernateUtil.getSession();
		
		session.save(addOffer);
		
		HibernateUtil.closeSession();
		
		return true;
		
	}

	@Override
	public void replyOffer(OfferPool addToOffer, InventoryJoin replyOffer) {
		
		Session session = HibernateUtil.getSession();
		
		addToOffer.setReply_inventory_id(replyOffer);
		
		session.merge(addToOffer);
		HibernateUtil.closeSession();

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

	@Override
	public void cancelOffer(OfferPool deleteThis) {
		
		int deleteID = deleteThis.getOffer_pool_id();

		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("DELETE from offer_pool WHERE offer_pool_id = ?1").setParameter(1,  deleteID);
		
		
		HibernateUtil.closeSession();
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateOffer(OfferPool offer_status_id) {
		
		Session session = HibernateUtil.getSession();
		
		session.merge(offer_status_id);
		
		HibernateUtil.closeSession();

	}

}
