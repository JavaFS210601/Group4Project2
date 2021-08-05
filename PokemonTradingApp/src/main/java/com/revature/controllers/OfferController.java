package com.revature.controllers;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.CurrentUserDAO;
import com.revature.daos.InventoryDAO;
import com.revature.daos.OfferPoolDAO;
import com.revature.daos.UserDAO;
import com.revature.dto.EmptyOfferDTO;
import com.revature.dto.OfferDTO;
import com.revature.dto.ReplyOfferDTO;
import com.revature.models.CurrentUser;
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
	@GetMapping 
	public ResponseEntity getOffer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		if(req.getMethod().equals("GET")) {
			
			System.out.println("im fetching inventory");
			
			OfferService os = new OfferService();

//			CurrentUser currentUser = currentUserDao.getCurrentUser();
			
			List<OfferPool> offer = os.getOffer();
			
			System.out.println("in the controller the list is  " +  offer);
			
//			if(inventory != null) {
//				System.out.println("getting data from database");
//			}
			
//			String json = om.writeValueAsString(inventory);
//			res.getWriter().print(json);
//			res.setStatus(200);
			
			return ResponseEntity.status(200).body(offer);
		}
		return ResponseEntity.status(401).build();
		
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value ="/userpastoffer") 
	public ResponseEntity getuserPastOffer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		if(req.getMethod().equals("GET")) {
			OfferService os = new OfferService();
			List<OfferPool> offer = os.getOffer();
			
			CurrentUserDAO currentUserDao = new CurrentUserDAO();
			CurrentUser currentUser = currentUserDao.getCurrentUser();
			
			InventoryService is = new InventoryService();
			
			List<InventoryJoin> inventory = is.getInventory(currentUser);
			
			List<OfferPool> finaloffer= new ArrayList<OfferPool>();
			
			for(int i=0;i<offer.size();i++) {
				OfferPool temp= offer.get(i);
				
				if(temp.getOffer_status_id().getOffer_status_id()==3) {
					int offerInventoryId= temp.getReply_inventory_id().getInventory_id();
					for(int j=0;j<inventory.size();j++) {
						InventoryJoin temp2 = inventory.get(j);
						int id1= temp2.getInventory_id();
						if(id1==offerInventoryId) {
							finaloffer.add(temp);
						}
					}
				}
				
			}
			
			return ResponseEntity.status(200).body(finaloffer);
			
			
		}
		
		return ResponseEntity.status(401).build();
	}

	
	@SuppressWarnings("rawtypes")
	@GetMapping(value ="/userpendingoffer") 
	public ResponseEntity getuserPendingOffer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		if(req.getMethod().equals("GET")) {
			OfferService os = new OfferService();
			List<OfferPool> offer = os.getOffer();
			
			CurrentUserDAO currentUserDao = new CurrentUserDAO();
			CurrentUser currentUser = currentUserDao.getCurrentUser();
			
			InventoryService is = new InventoryService();
			
			List<InventoryJoin> inventory = is.getInventory(currentUser);
			
			List<OfferPool> finaloffer= new ArrayList<OfferPool>();
			
			for(int i=0;i<offer.size();i++) {
				OfferPool temp= offer.get(i);
				int offerInventoryId= temp.getPrimary_inventory_id().getInventory_id();
				if(temp.getOffer_status_id().getOffer_status_id()==2) {
					
					for(int j=0;j<inventory.size();j++) {
						InventoryJoin temp2 = inventory.get(j);
						int id1= temp2.getInventory_id();
						if(id1==offerInventoryId) {
							finaloffer.add(temp);
						}
					}
				}
				
			}
			
			return ResponseEntity.status(200).body(finaloffer);
			
			
		}
		
		return ResponseEntity.status(401).build();
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value ="/useropenoffer") 
	public ResponseEntity getuserOpenOffer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		if(req.getMethod().equals("GET")) {
			OfferService os = new OfferService();
			List<OfferPool> offer = os.getOffer();
			
			CurrentUserDAO currentUserDao = new CurrentUserDAO();
			CurrentUser currentUser = currentUserDao.getCurrentUser();
			
			InventoryService is = new InventoryService();
			
			List<InventoryJoin> inventory = is.getInventory(currentUser);
			
			List<OfferPool> finaloffer= new ArrayList<OfferPool>();
			
			for(int i=0;i<offer.size();i++) {
				OfferPool temp= offer.get(i);
				int offerInventoryId= temp.getPrimary_inventory_id().getInventory_id();
				if(temp.getOffer_status_id().getOffer_status_id()==1) {
					
					for(int j=0;j<inventory.size();j++) {
						InventoryJoin temp2 = inventory.get(j);
						int id1= temp2.getInventory_id();
						if(id1==offerInventoryId) {
							finaloffer.add(temp);
						}
					}
				}
				
			}
			
			return ResponseEntity.status(200).body(finaloffer);
			
			
		}
		
		return ResponseEntity.status(401).build();
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping (value="/addoffer",consumes = MediaType.TEXT_PLAIN_VALUE)
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
			
			System.out.println("Printing offerDto "+offerDto);
			
			OfferStatus status = new OfferStatus(1, "Open");
			
			InventoryDAO inventoryDao = new InventoryDAO();
			
			InventoryJoin inventoryJoin = inventoryDao.getInventoryById(offerDto.getInventory_id());
			
			
			OfferPool offerPool = new OfferPool(inventoryJoin, null, status);
			
			if(os.newOffer(offerPool)) {
				
				System.out.println("I am in the offer controller");					
				
				return ResponseEntity.status(200).build();			
			}
			
		}
		return ResponseEntity.status(401).build();
		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping (value = "/replyoffer", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity updateOffer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
	if(req.getMethod().equals("POST")) {
		
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
			
			System.out.println(body);
			
			ReplyOfferDTO replyOffer = om.readValue(body, ReplyOfferDTO.class);
			
			if(os.replyOffer(replyOffer)) {
				
				OfferPoolDAO offerdao = new OfferPoolDAO();
				
				int offerId= replyOffer.getOffer_id();
				
				OfferPool offer = offerdao.getOfferByID(offerId);
				
				offerdao.updateOfferPending(offer);
				
				return ResponseEntity.status(200).build();	
			}
					
			
		
	}
	return ResponseEntity.status(401).build();
	

	}
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping (value = "/declineoffer", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity emptyOffer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		
		OfferService os = new OfferService();
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		while(line != null) {
			
			sb.append(line);
			line = reader.readLine();
			
		}
		
		String body = new String(sb);
		
		EmptyOfferDTO offer = om.readValue(body, EmptyOfferDTO.class);
		
		
		if(os.emptyOffer(offer.getOffer_id())) {
			return ResponseEntity.status(200).build();	
		}
		
		
		
		
		return ResponseEntity.status(401).build();
		
		
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping (value = "/acceptoffer", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity acceptOffer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		OfferService os = new OfferService();
		InventoryDAO inventoryDao = new InventoryDAO();
		OfferPoolDAO offerdao= new OfferPoolDAO();
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		while(line != null) {
			
			sb.append(line);
			line = reader.readLine();
			
		}
		
		String body = new String(sb);
		EmptyOfferDTO offer = om.readValue(body, EmptyOfferDTO.class);
		
		if(os.acceptOffer(offer.getOffer_id())) {
			
			
			System.out.println("Hello I am coming into the if statement");
			
			OfferPool acceptedOffer=offerdao.getOfferByID(offer.getOffer_id());
			
			System.out.println("Accepted offer is "+acceptedOffer);
			
			int primaryuserID = acceptedOffer.getPrimary_inventory_id().getUser_id_fk();
			
			int primaryinventoryID= acceptedOffer.getPrimary_inventory_id().getInventory_id();
			
	
			
			InventoryJoin primaryInventory = inventoryDao.getInventoryById(primaryinventoryID);
			
			System.out.println("Primary inventory is "+primaryInventory);
			
			int replyuserID = acceptedOffer.getReply_inventory_id().getUser_id_fk();
			
			int replyinventoryID =acceptedOffer.getReply_inventory_id().getInventory_id();
			
			
			
			InventoryJoin replyInventory = inventoryDao.getInventoryById(replyinventoryID);
			
			System.out.println("Reply Inventory is "+replyInventory);
			
			inventoryDao.updateOwner(primaryInventory, replyuserID);
		
		inventoryDao.updateOwner(replyInventory,primaryuserID );
			
			
			
			
			
			return ResponseEntity.status(200).build();	
		}
		
	
		return ResponseEntity.status(401).build();
		
	}
		
		
		
	
	
}
