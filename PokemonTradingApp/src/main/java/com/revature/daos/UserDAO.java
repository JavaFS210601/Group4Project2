package com.revature.daos;


import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

@Component
public class UserDAO implements UserDAOInterface {
	
	@Override
	public boolean addUser(PokeUsers newUser) {

		
		
		PokeUsers p=null;
		
		p= getUserByUsername(newUser.getPoke_username());
		
		if(p!=null) {
			return false;
		}
		
		p= getUserByContact(newUser.getPoke_contact_info());
		
		if(p!=null) {
			return false;
		}

		Session ses = HibernateUtil.getSession(); 
		ses.save(newUser); 
		
		HibernateUtil.closeSession();
		
		return true;
		
	}

	@Override
	public List<PokeUsers> getAllUsers() {
		Session ses = HibernateUtil.getSession();
		
		List<PokeUsers> userList = ses.createQuery("FROM poke_users").list(); //at the end, we're turning the Query object into a List
		
		//warning is unimportant, it's complaining about conversion
		//it wants a specific generic but it's not important. We could probably use casting to get rid of it
		
		HibernateUtil.closeSession();
		
		return userList;
	}

	@Override
	public PokeUsers getUserById(int poke_user_id) {
		
		Session ses = HibernateUtil.getSession();
		PokeUsers user = ses.get(PokeUsers.class, poke_user_id);
		HibernateUtil.closeSession();
		return user;
	}

	@Override
	public PokeUsers getUserByUsername(String poke_username) {
		
		System.out.println("I am getting user for "+ poke_username);
		
		Session ses = HibernateUtil.getSession();
		PokeUsers user = (PokeUsers) ses.createQuery("FROM PokeUsers WHERE poke_username = ?1" ).setParameter(1, poke_username).uniqueResult();
//		PokeUsers user = (PokeUsers) ses.createQuery("FROM PokeUsers WHERE poke_username = ?1").setParameter(1, poke_username).getSingleResult();
//		for(int i = 0; i < user.size(); i++) {
//			if(user.get(i).getPoke_username().equals(poke_username)) {
//				System.out.println(i);
//				return user.get(i);
//			}
//			
//		}
		HibernateUtil.closeSession();
		System.out.println(user);
		return user; 
	}

	@Override
	public PokeUsers getUserPassword(String poke_password) {
		
		Session ses = HibernateUtil.getSession();
		System.out.println("I am getting password");
		PokeUsers user = ses.get(PokeUsers.class, poke_password);
		HibernateUtil.closeSession();
		return user;
	}

	@Override
	public PokeUsers getUserByContact(String poke_contact) {
		
		
		Session ses = HibernateUtil.getSession();
		PokeUsers user = (PokeUsers) ses.createQuery("FROM PokeUsers WHERE poke_contact_info = ?1" ).setParameter(1, poke_contact).uniqueResult();
		//ses.createQuery("FROM PokeUsers WHERE poke_contact_info = ?1").setParameter(1, poke_contact).getSingleResult();
		
		HibernateUtil.closeSession();
		return user;
		
		
	}

}
