package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserDAO;
import com.revature.models.PokeUsers;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class PokeController {
	
	private PokeUsers pokeuser;

	public PokeController(PokeUsers pokeuser) {
		super();
		this.pokeuser = pokeuser;
	}
	
//	@RequestMapping(method=RequestMethod.GET) //Ensures that any GET requests to /avengeres uses this method
//	@ResponseBody //This will parse any Java into JSON to send back as the response 
//	public List<UserDAO> getAllUsers(){
//		return Arrays.asList(pokeuser.getAllUsers()); 
//	}
	
	
	

	
}
