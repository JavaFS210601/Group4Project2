package com.revature.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.InventoryJoin;
import com.revature.models.OfferPool;
import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

@Repository
public class InventoryDAO implements InventoryDAOInterface{

	
	@Override
	public InventoryJoin getInventoryById(int inventory_id) {
		
		Session ses = HibernateUtil.getSession();
		
		InventoryJoin inventory = (InventoryJoin) ses.createQuery("FROM InventoryJoin WHERE inventory_id = ?1").setParameter(1,  inventory_id).uniqueResult();
		
		HibernateUtil.closeSession();
		
		return inventory;
		
	}
	
	@Override
	public InventoryJoin getUserByInventoryId(int inventory_id) {
		
		Session ses = HibernateUtil.getSession();
		
		//get the role  based on the id for the role by using the get method
		InventoryJoin ij = ses.get(InventoryJoin.class, inventory_id);
			
		//close the hibernate session
		HibernateUtil.closeSession();
		//return the role object
		return ij;
	}

	@Override
	public List<InventoryJoin> getInventoriesByUser(PokeUsers user) {
		Session ses = HibernateUtil.getSession();
		int userID = user.getPoke_user_id();
		
		List<InventoryJoin> myInventories = ses.createQuery("FROM InventoryJoin WHERE user_id_fk = ?1").setParameter(1,  userID).list();

		HibernateUtil.closeSession();
		
		
		return myInventories;
	}

	@Override
	public InventoryJoin addPokemon(InventoryJoin newPokemon) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(newPokemon);
		
		HibernateUtil.closeSession();

		return null;
	}
	
//	@Override
//	public void updatePrimaryInventory(InventoryJoin offer_status_id) {
//		
//		Session session = HibernateUtil.getSession();
//		
//		session.merge(offer_status_id);
//		
//		HibernateUtil.closeSession();
//
//	}
	
	@Override
	public void updateReplyInventory(InventoryJoin offer, OfferPool updateThis) {
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("UPDATE OfferPool SET reply_inventory_id = offer WHERE offer_id = ?1").setParameter(1, updateThis.getOffer_pool_id());
		
		q.executeUpdate();
		
		HibernateUtil.closeSession();

	}

	@Override
	public void updateOwner(InventoryJoin inventory,int newUser) {
		
		System.out.println("I am changing the inventory "+ inventory.getInventory_id() +" the new user Id is :" +newUser);
		
		Session session = HibernateUtil.getSession();
		
		Transaction txn = session.beginTransaction();
		
		session.detach(inventory);
		
		inventory.setUser_id_fk(newUser);
		
		
		session.update(inventory);
				
		
//		Query q = session.createQuery("UPDATE OfferPool SET offer_status_id = ?1 WHERE offer_id = ?2").setParameter(1, i).setParameter(2, offerP.getOffer_pool_id());
//		
//		q.executeUpdate();
//		
		txn.commit();
		
		HibernateUtil.closeSession();
		
	}
	
	

}
