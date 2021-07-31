package com.revature.daos;

import java.util.List;
import java.util.Optional;

import com.revature.models.PokeUsers;

public interface UserDAOInterface {

	public boolean addUser(PokeUsers user);
	
	public List<PokeUsers> getAllUsers();
	
	public PokeUsers getUserById(int poke_user_id);
	
	public PokeUsers getUserByUsername(String poke_username);
	
	public PokeUsers getUserPassword(String poke_password);
	
	public PokeUsers getUserByContact(String poke_contact);
 }
