package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDAO;
import com.revature.dto.InventoryDTO;
import com.revature.models.InventoryJoin;
import com.revature.models.PokeStatus;
import com.revature.models.PokeUsers;
import com.revature.services.InventoryService;
import com.revature.services.PokeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {
	
	//private PokeService ps;
	ObjectMapper om = new ObjectMapper();
	

	public InventoryController() {
		super();
	}
	



		@SuppressWarnings("rawtypes")
		@PostMapping (consumes = MediaType.TEXT_PLAIN_VALUE)
		public ResponseEntity addInventory(HttpServletRequest req, HttpServletResponse res) throws IOException{
			
			if(req.getMethod().equals("POST")) {
				
				UserDAO ud = new UserDAO();
				
				InventoryService is = new InventoryService();
				
				BufferedReader reader = req.getReader();
				
				StringBuilder sb = new StringBuilder();
				
				String line = reader.readLine();
				
				while(line != null) {
					
					sb.append(line);
					line = reader.readLine();
				}
				
				String body = new String(sb);
				
				System.out.println(sb);
				
				InventoryDTO inventoryDto = om.readValue(body, InventoryDTO.class);
				
				String poke_username = inventoryDto.getPoke_username();
				
				System.out.println(poke_username);
				
				PokeUsers user = ud.getUserByUsername(poke_username);
				
				PokeStatus status = new PokeStatus(1, "Available");
				
				InventoryJoin inventory = new InventoryJoin(user.getPoke_user_id(), inventoryDto.getPoke_id_fk(), status);
	
				
				if(is.addInventory(inventory)) {
					
					System.out.println("I am in the inventory controller");					
					
					return ResponseEntity.status(200).build();			
				}
				
			}
			return ResponseEntity.status(401).build();
			
		}
}