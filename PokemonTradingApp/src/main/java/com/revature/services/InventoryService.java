package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.InventoryDAO;
import com.revature.daos.UserDAO;
import com.revature.models.CurrentUser;
import com.revature.models.InventoryJoin;
import com.revature.models.PokeUsers;

@Service
public class InventoryService {
	
	InventoryDAO inventoryDao = new InventoryDAO();

	public boolean addInventory(InventoryJoin inventory) {

	inventoryDao.addPokemon(inventory);
		
		return true;
	}

	
	
	public List<InventoryJoin> getInventory(CurrentUser currentUser) {
		
		InventoryDAO inventoryDao = new InventoryDAO();
		
		UserDAO userDao = new UserDAO();
		PokeUsers user = userDao.getUserById(currentUser.getPoke_user_id());
		
		List<InventoryJoin> inventoryJoin = inventoryDao.getInventoriesByUser(user);
		
		
		return inventoryJoin;
	}

}
