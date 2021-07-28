package com.revature;

import com.revature.daos.UserDAO;
import com.revature.models.PokeUsers;

public class Launcher {

	private static UserDAO uDAO = new UserDAO();
	
	public static void main(String[] args) {
		
		
		PokeUsers pu = new PokeUsers();
		pu.setPoke_username(null);
		
		PokeUsers p1 = new PokeUsers("muffin man", "1235","john cena", "1234567894");
		
		uDAO.addUser(p1);
	}
}
