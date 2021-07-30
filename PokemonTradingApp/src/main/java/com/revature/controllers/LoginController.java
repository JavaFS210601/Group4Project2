package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.PokeUsers;
import com.revature.services.LoginService;
import com.revature.services.PokeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/login", produces= "application/json" )
public class LoginController {
	
	private LoginService ls;
	private PokeService ps;
	
	@Autowired
	public LoginController(LoginService loginService, PokeService pokeService) {
		super();
		this.ls = loginService;
		this.ps = pokeService;
		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity login(@RequestBody PokeUsers user, HttpSession session) {
		
		if(ls.login(user)) {
			
			System.out.println("I am in the controller ");
			
			
			//why u give me error?
			String username = user.getPoke_username();
			String password = user.getPoke_password();
			
			session.setAttribute("poke_username", username);
			session.setAttribute("poke_password", password);
			return ResponseEntity.status(200).build();			
		}
		
		return ResponseEntity.status(401).build();
	}
	
	
	

}
