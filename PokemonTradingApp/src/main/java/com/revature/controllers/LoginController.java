package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	
//	@SuppressWarnings("rawtypes")
//    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity login(@RequestBody PokeUsers user, HttpSession session) {
//
//        if(ls.login(user)) {
//
//            System.out.println("I am in the controller ");
//
//
//            //why u give me error?
//            String username = user.getPoke_username();
//            String password = user.getPoke_password();
//
//            session.setAttribute("poke_username", username);
//            session.setAttribute("poke_password", password);
//            return ResponseEntity.status(200).build();
//        }
//
//        return ResponseEntity.status(401).build();
//    }
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping (consumes = MediaType.TEXT_PLAIN_VALUE)
	
	public ResponseEntity login(HttpSession session, HttpServletRequest req) throws IOException{
		ObjectMapper om = new ObjectMapper();
		
		BufferedReader reader = req.getReader();
		
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		System.out.println(sb);
		
		PokeUsers user = om.readValue(body, PokeUsers.class);
		System.out.println(user);
		
//		System.out.println(lDTO.getUsername());
//		System.out.println(lDTO.getPassword());
		
		if(ls.login(user)) {
			
			System.out.println("I am in the login controller ");
			
			
			
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
