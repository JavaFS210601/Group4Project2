package com.revature.daos;

import com.revature.models.InventoryJoin;

public interface InventoryDAOInterface {

	public InventoryJoin getUserByInventoryId(int inventory_id);
}
