package com.revature.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.CurrentUser;
import com.revature.utils.HibernateUtil;

@Repository
public class CurrentUserDAO implements CurrentUserDAOInterface{

	@Override
	public void addCurrentUser(CurrentUser user) {
		
		Session session = HibernateUtil.getSession();
		
		session.save(user);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public CurrentUser getCurrentUser() {
		
		Session session = HibernateUtil.getSession();
		
		CurrentUser userList = (CurrentUser) session.createQuery("FROM CurrentUser").uniqueResult();
		
		HibernateUtil.closeSession();
		
		return userList;
	}

	@Override
	public void deleteCurrentUser() {

		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("DELETE from CurrentUser");

		HibernateUtil.closeSession();
		
	}

}