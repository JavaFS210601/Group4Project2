package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.InventoryJoin;
import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

@Repository
public class InventoryDAO implements InventoryDAOInterface{

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
		List<InventoryJoin> myInventories = ses.createQuery("FROM inventory_join WHERE user_id_fk = ?1").setParameter(1,  userID).list();
		
		
		HibernateUtil.closeSession();
		
		
		return myInventories;
	}
	
	

}
