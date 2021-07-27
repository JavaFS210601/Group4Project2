package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

public class UserDAO implements UserDAOInterface {
	
	@Override
	public void addUser(PokeUsers newUser) {

		Session ses = HibernateUtil.getSession(); 
		
		ses.save(newUser); 
		
		HibernateUtil.closeSession();
		
	}

}
