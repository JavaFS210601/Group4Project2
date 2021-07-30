package com.revature.daos;

import java.util.List;

import com.revature.models.InventoryJoin;
import com.revature.models.PokeUsers;

public interface InventoryDAOInterface {

	public InventoryJoin getUserByInventoryId(int inventory_id);
	
	public List<InventoryJoin> getInventoriesByUser(PokeUsers user);
	
	public InventoryJoin addPokemon(InventoryJoin newPokemon);
	
	
}
