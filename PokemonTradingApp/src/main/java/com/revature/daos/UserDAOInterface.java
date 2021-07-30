package com.revature.daos;

import java.util.List;

import com.revature.models.PokeUsers;

public interface UserDAOInterface {

	public void addUser(PokeUsers user);
	
	public List<PokeUsers> getAllUsers();
	
	public PokeUsers getUserById(int poke_user_id);
	
	public PokeUsers getUserUsername(String poke_username);
	
	public PokeUsers getUserPassword(String poke_password);
 }
