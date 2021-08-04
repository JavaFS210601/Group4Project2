package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.daos.CurrentUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.CurrentUser;
import com.revature.models.PokeUsers;

@Service
@SessionAttributes("Session")
public class LoginService {

	private UserDAO userDao;
	
	@Autowired
	public LoginService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	public boolean login(PokeUsers user) { 
		
		boolean validated = false;
		
		String username = user.getPoke_username();
		String password = user.getPoke_password();
		
		System.out.println("im here");
		PokeUsers dataUser= userDao.getUserByUsername(username);
		
		if(dataUser.getPoke_password().equals(password)) {
			
			CurrentUserDAO currentUserDao = new CurrentUserDAO();
			currentUserDao.deleteCurrentUser();
//			
			CurrentUser currentUser = new CurrentUser(dataUser.getPoke_username(), dataUser.getPoke_user_id());
//			
			currentUserDao.addCurrentUser(currentUser);
			
			validated =true;
		}
		
		
		
//		Optional<PokeUsers> pkUser = Optional.ofNullable(userDao.getUserUsername(user.getPoke_username()));
//		
//		if(pkUser.isPresent()) {
//			
//			PokeUsers pUser = pkUser.get();
//			
//			if(user.getPoke_password().compareTo(pUser.getPoke_password()) == 0) {
//				
//				validated = true;
//			}
//		}
		return validated;
	}
	
	
	
}
