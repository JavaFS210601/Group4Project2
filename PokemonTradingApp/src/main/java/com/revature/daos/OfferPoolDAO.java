package com.revature.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.InventoryJoin;
import com.revature.models.OfferPool;
import com.revature.models.OfferStatus;
import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

@Repository
public class OfferPoolDAO implements OfferPoolDAOInterface{

	@Override
	public List<OfferPool> getAllOffers() {
		
		Session session = HibernateUtil.getSession();
		
		List<OfferPool> currentOffers =  session.createQuery("FROM OfferPool").list();
		HibernateUtil.closeSession();
		System.out.println("I am returning list "+ currentOffers);
		return currentOffers;
	}

	@Override
	public OfferPool getOfferByID(int findID) {
		
		Session session = HibernateUtil.getSession();
		
		OfferPool specificOffer = (OfferPool) session.createQuery("FROM OfferPool WHERE offer_pool_id = ?1").setParameter(1,  findID).getSingleResult();
		HibernateUtil.closeSession();
		// TODO Auto-generated method stub
		return specificOffer;
	}

	@Override
	public List<OfferPool> getOffersByUser(PokeUsers user) {
		Session session = HibernateUtil.getSession();
		
		
		List<OfferPool> myOffers =  session.createQuery("FROM OfferPool INNER JOIN inventory_join ON offer_pool.primary_inventory_id = inventory_join.inventory_id WHERE user_id_fk = ?1").setParameter(1,  user.getPoke_user_id()).list();
		HibernateUtil.closeSession();
		
		// TODO Auto-generated method stub
		return myOffers;
	}

	@Override
	public void setOfferStatus(OfferPool offer, OfferPool newStatus) {
		Session session = HibernateUtil.getSession();
		//offer.setStatus_status_id(newStatus);
	
		Query q = session.createQuery("UPDATE OfferPool SET offer_status_id = ?1 WHERE offer_pool_id = ?2").setParameter(1,  newStatus).setParameter(2, offer.getOffer_pool_id());
		
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
//	@Transactional
	public boolean replyOffer(OfferPool addToOffer, InventoryJoin replyOffer) {
		
		Session session = HibernateUtil.getSession();
//		Transaction tx = session.beginTransaction();
		Transaction txn = session.beginTransaction();
		Query q = session.createQuery("UPDATE OfferPool SET reply_inventory__id = ?1 WHERE offer_pool_id = ?2").setParameter(1, replyOffer.getInventory_id()).setParameter(2, addToOffer.getOffer_pool_id());
		
		q.executeUpdate();
		txn.commit();
//		q.saveOrUpdate();
		HibernateUtil.closeSession();
		return true;
	}

	@Override
	public List<OfferPool> getOffersByStatus(int offerStatus) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSession();
		
		List<OfferPool> myOffers =  session.createQuery("FROM OfferPool WHERE offer_status_id = ?1").setParameter(1,  offerStatus).list();
		HibernateUtil.closeSession();
		
		// TODO Auto-generated method stub
		return myOffers;
		
	}

	@Override
	public void cancelOffer(OfferPool deleteThis) {
		
		int deleteID = deleteThis.getOffer_pool_id();

		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("DELETE from OfferPool WHERE offer_pool_id = ?1").setParameter(1,  deleteID);
		
		
		HibernateUtil.closeSession();
		// TODO Auto-generated method stub
		
	}
	
	@Override
	//OPEN
	public void updateOffer(OfferPool offer) {
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("UPDATE OfferPool SET offer_status_id = ?1 WHERE offer_id = ?2").setParameter(1, 1).setParameter(2, offer.getOffer_pool_id());
		
		q.executeUpdate();
		
		HibernateUtil.closeSession();

	}
	
	@Override
	//PENDING
	public void updateOfferPending(OfferPool offerP) {
		
		
		
		OfferPoolDAO od = new OfferPoolDAO();
		
		
		OfferStatus status = new OfferStatus(2,"Pending");
		
		
		
		
		OfferPool offer = od.getOfferByID(offerP.getOffer_pool_id());
		
		Session session = HibernateUtil.getSession();
		
		Transaction txn = session.beginTransaction();
		
		session.detach(offer);
		
		offer.setOffer_status_id(status);
		
		session.update(offer);
				
		
//		Query q = session.createQuery("UPDATE OfferPool SET offer_status_id = ?1 WHERE offer_id = ?2").setParameter(1, i).setParameter(2, offerP.getOffer_pool_id());
//		
//		q.executeUpdate();
//		
		txn.commit();
		
		HibernateUtil.closeSession();

	}
	
	@Override
	//COMPLETE
	public void updateOfferComplete(OfferPool offerC) {
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("UPDATE OfferPool SET offer_status_id = ?1 WHERE offer_id = ?2").setParameter(1, 3).setParameter(2, offerC.getOffer_pool_id());
		
		q.executeUpdate();
		
		HibernateUtil.closeSession();

	}

	public void emptyOffer(int i) {
		
		OfferPoolDAO od = new OfferPoolDAO();
		
		OfferStatus status = new OfferStatus(1,"Open");
		
		OfferPool offer = od.getOfferByID(i);
		
Session session = HibernateUtil.getSession();
		
		Transaction txn = session.beginTransaction();
		
		session.detach(offer);
		
		offer.setOffer_status_id(status);
		offer.setReply_inventory_id(null);
		
		session.update(offer);
				
		
//		Query q = session.createQuery("UPDATE OfferPool SET offer_status_id = ?1 WHERE offer_id = ?2").setParameter(1, i).setParameter(2, offerP.getOffer_pool_id());
//		
//		q.executeUpdate();
//		
		txn.commit();
		
		HibernateUtil.closeSession();
		
		
		
		
	}

	public void acceptOffer(int offer_id) {
		OfferPoolDAO od = new OfferPoolDAO();
		OfferStatus status = new OfferStatus(3,"Completed");
		
		OfferPool offer = od.getOfferByID(offer_id);
Session session = HibernateUtil.getSession();
		
		Transaction txn = session.beginTransaction();
		
		session.detach(offer);
		
		offer.setOffer_status_id(status);
		
		
		session.update(offer);
				
		
//		Query q = session.createQuery("UPDATE OfferPool SET offer_status_id = ?1 WHERE offer_id = ?2").setParameter(1, i).setParameter(2, offerP.getOffer_pool_id());
//		
//		q.executeUpdate();
//		
		txn.commit();
		
		HibernateUtil.closeSession();
		
	}

}
