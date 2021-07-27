package com.revature.daos;

import com.revature.models.PokeUsers;

public interface LoginDAOInterface {
		
		public PokeUsers getUserPass(String poke_username, String poke_password);
		
	}

