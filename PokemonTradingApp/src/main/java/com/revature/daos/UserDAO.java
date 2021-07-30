package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.PokeUsers;
import com.revature.utils.HibernateUtil;

@Repository
public class UserDAO implements UserDAOInterface {
	
	@Override
	public void addUser(PokeUsers newUser) {

		Session ses = HibernateUtil.getSession(); 
		
		ses.save(newUser); 
		
		HibernateUtil.closeSession();
		
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
		PokeUsers user = ses.get(PokeUsers.class, poke_username);
		HibernateUtil.closeSession();
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

}
