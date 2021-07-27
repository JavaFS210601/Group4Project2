package com.revature;

import com.revature.daos.UserDAO;
import com.revature.models.PokeUsers;

public class Launcher {

	private static UserDAO uDAO = new UserDAO();
	
	public static void main(String[] args) {
		
		
		PokeUsers pu = new PokeUsers();
		pu.setPoke_username(null);
		
		PokeUsers p1 = new PokeUsers(1, "pokemon", "password", "Sid The Sloth", "8881111234");
		
		uDAO.addUser(p1);
	}
}
