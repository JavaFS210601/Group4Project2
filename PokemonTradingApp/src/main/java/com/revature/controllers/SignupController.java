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

import com.revature.services.PokeService;
import com.revature.services.SignupService;

@CrossOrigin
@RestController
@RequestMapping(value = "/signup", produces= "application/json" )
public class SignupController {

	private SignupService ss;
	private PokeService ps;
	
	
	@Autowired
		public SignupController(SignupService ss, PokeService ps) {
		super();
		this.ss = ss;
		this.ps = ps;
	}

		
		@SuppressWarnings("rawtypes")
		@PostMapping (consumes = MediaType.TEXT_PLAIN_VALUE)
		
		public ResponseEntity signup(HttpSession session, HttpServletRequest req) throws IOException{
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
			
//			System.out.println(lDTO.getUsername());
//			System.out.println(lDTO.getPassword());
			
			if(ss.signup(user)) {
				
				System.out.println("I am in the controller ");
				
				return ResponseEntity.status(200).build();			
			}
			
			return ResponseEntity.status(401).build();
		}
		
		
		
		
		
		

}

