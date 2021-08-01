package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.daos.InventoryDAO;
import com.revature.models.InventoryJoin;

@Service
public class InventoryService {
	
	InventoryDAO inventoryDao = new InventoryDAO();

	public boolean addInventory(InventoryJoin inventory) {

	inventoryDao.addPokemon(inventory);
		
		return true;
	}

}
