package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.LoginDAO;
import com.revature.daos.UserDAO;
import com.revature.models.PokeUsers;

public class LoginService {

	
	
	private LoginDAO lDAO = new LoginDAO();
	
	UserDAO userDao = new UserDAO();
	
	public int login(String username, String password) {
		
		
		 
		
		UserDAO allUsers = new UserDAO();
		List<PokeUsers> checkLogin = allUsers.getAllUsers();
		
		for(PokeUsers test : checkLogin) {
			
			if(username.equals(test.getPoke_username()) && password.equals(test.getPoke_password())) {
				
				return test.getPoke_user_id();
			}
			
			
		}
		
		return -1;
	}
	
	public boolean login2(String username, String password) {
		
		//get credentials from DAO
		List<PokeUsers> userList = new ArrayList<>();
		
		
		
		userList = userDao.getAllUsers();
		
		for(int i = 0; i < userList.size(); i++) {
			if(username.equals(userList.get(i).getPoke_username()) && password.equals(userList.get(i).getPoke_password())) {
				return true;
			}
			
			
		}
		return false;
	}

}
