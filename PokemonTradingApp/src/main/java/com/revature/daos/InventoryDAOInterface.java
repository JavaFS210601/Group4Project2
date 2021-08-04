package com.revature.daos;

import java.util.List;

import com.revature.models.InventoryJoin;
import com.revature.models.OfferPool;
import com.revature.models.PokeUsers;

public interface InventoryDAOInterface {

	public InventoryJoin getUserByInventoryId(int inventory_id);
	
	public List<InventoryJoin> getInventoriesByUser(PokeUsers user);
	
	public InventoryJoin addPokemon(InventoryJoin newPokemon);
	
	public InventoryJoin getInventoryById(int inventory_id);

//	public void updatePrimaryInventory(InventoryJoin offer_status_id);
	
	public void updateReplyInventory(InventoryJoin offer, OfferPool updateThis); 
	
	public void updateOwner(InventoryJoin inventory, int newUser);
	
	
}
