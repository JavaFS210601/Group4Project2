package com.revature.dto;

public class LoginDTO {

	public String poke_username;
	public String poke_password;
	
	
	
	
	
	//no-args constructor
	public LoginDTO() {
		super();
		
	}

	//all-args constructor
	public LoginDTO(String username, String password) {
		super();
		this.poke_username = username;
		this.poke_password = password;
	}

	
	//getters and setters
	public String getUsername() {
		return poke_username;
	}

	public void setUsername(String username) {
		this.poke_username = username;
	}

	public String getPassword() {
		return poke_password;
	}

	public void setPassword(String password) {
		this.poke_password = password;
	}
}
