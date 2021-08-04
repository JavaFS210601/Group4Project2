package com.revature.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.CurrentUser;
import com.revature.utils.HibernateUtil;

@Repository
public class CurrentUserDAO implements CurrentUserDAOInterface{

	@Override
	public void addCurrentUser(CurrentUser user) {
		
		System.out.println("the current user is: " + user);
		
		Session session = HibernateUtil.getSession();
		
		Transaction txn = session.beginTransaction();
		
//		Query q = session.createQuery("Insert into CurrentUser (poke_user_id, poke_username) values(?1, ?2)");
//		
//		q.setParameter(1, user.getPoke_user_id());
//		q.setParameter(2, user.getPoke_username());
//		
//		q.executeUpdate();
		session.save(user);
		
		txn.commit();
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public CurrentUser getCurrentUser() {
		
		System.out.println("in current user method");
		
		Session session = HibernateUtil.getSession();
		
		CurrentUser userList = (CurrentUser) session.createQuery("FROM CurrentUser").uniqueResult();
		
		System.out.println("the user list is" + userList);
		
		HibernateUtil.closeSession();
		
		return userList;
	}

	@Override
	public void deleteCurrentUser() {
		
		System.out.println("in delete user method");

		Session session = HibernateUtil.getSession();
		
		Transaction txn = session.beginTransaction();
		
		Query q = session.createQuery("DELETE from CurrentUser");
		q.executeUpdate();
		txn.commit();
		HibernateUtil.closeSession();
		
	}

}
