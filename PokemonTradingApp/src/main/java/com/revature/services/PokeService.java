package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.models.PokeUsers;

@Service
public class PokeService {

	private UserDAO userDao;
	
	@Autowired
	public PokeService() {
		super();
	}

	public PokeUsers getPoke_username(PokeUsers user) {
		
		Optional<PokeUsers> pkUser = null;
		
		pkUser =  Optional.ofNullable(userDao.getUserUsername(user.getPoke_username()));
				
		if(pkUser.isPresent()) {
			
			return pkUser.get();
		}
		
		return null;
	}

	public PokeUsers getPoke_password(PokeUsers user) {
	
		Optional<PokeUsers> pkUser = null;
		
		pkUser =  Optional.ofNullable(userDao.getUserPassword(user.getPoke_password()));
				
		if(pkUser.isPresent()) {
			
			return pkUser.get();
		
	}
		return null;
	
	
	}
}
