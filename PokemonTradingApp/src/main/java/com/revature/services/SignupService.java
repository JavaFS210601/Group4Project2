package com.revature.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.daos.UserDAO;
import com.revature.models.PokeUsers;


@Service
@SessionAttributes("Session")
public class SignupService {
	
	UserDAO ud= new UserDAO();

	public boolean signup(PokeUsers user) {
		if(ud.addUser(user)) {
			return true;
		}
		return false;
	}

}
