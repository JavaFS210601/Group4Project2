package com.revature.daos;

import com.revature.models.CurrentUser;

public interface CurrentUserDAOInterface {
	
	public void addCurrentUser(CurrentUser user);
	
	public CurrentUser getCurrentUser();
	
	public void deleteCurrentUser();
}
