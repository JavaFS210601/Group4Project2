package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.InventoryDAO;
import com.revature.daos.UserDAO;
import com.revature.dto.OfferDTO;
import com.revature.models.InventoryJoin;
import com.revature.models.OfferPool;
import com.revature.models.OfferStatus;
import com.revature.services.InventoryService;
import com.revature.services.OfferService;

@CrossOrigin
@RestController
@RequestMapping(value = "/offer")
public class OfferController {
	
	ObjectMapper om = new ObjectMapper();
	
	public OfferController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("rawtypes")
	@PostMapping (consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity addOffer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		if(req.getMethod().equals("POST")) {
			
			UserDAO ud = new UserDAO();
			InventoryService is = new InventoryService();
			OfferService os = new OfferService();
			
			
			BufferedReader reader = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while(line != null) {
				
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			
			System.out.println(sb);
			
			OfferDTO offerDto = om.readValue(body, OfferDTO.class);
			
			OfferStatus status = new OfferStatus(1, "Open");
			
			InventoryDAO inventoryDao = new InventoryDAO();
			
			InventoryJoin inventoryJoin = inventoryDao.getInventoryById(offerDto.getInventory_id());
			InventoryJoin inventoryJoins = null;
			
			OfferPool offerPool = new OfferPool(inventoryJoin, inventoryJoins, status);
			
			if(os.newOffer(offerPool)) {
				
				System.out.println("I am in the offer controller");					
				
				return ResponseEntity.status(200).build();			
			}
			
		}
		return ResponseEntity.status(401).build();
		
	}

}