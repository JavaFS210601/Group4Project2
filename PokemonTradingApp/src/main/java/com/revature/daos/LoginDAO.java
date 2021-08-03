package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

public class LoginDAO implements LoginDAOInterface{

	@Override
	public PokeUsers getUserPass(String poke_username, String poke_password) {
		
		Session session = HibernateUtil.getSession();
		
		PokeUsers user = (PokeUsers) session.createQuery("FROM PokeUsers WHERE poke_username = ?1 AND poke_password = ?2").setParameter(1,  poke_username).setParameter(2,  poke_password).getSingleResult();
		
		HibernateUtil.closeSession();
		
		if(user.getPoke_username().equals(poke_username) && user.getPoke_password().equals(poke_password)) {
			return user;
		}
		
		return null;
	}
	
}

	

