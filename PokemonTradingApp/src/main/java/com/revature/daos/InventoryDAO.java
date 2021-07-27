package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.InventoryJoin;
import com.revature.utils.HibernateUtil;

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

}
