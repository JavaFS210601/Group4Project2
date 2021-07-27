package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.PokeUsers;

public interface PokeUsersDAO extends JpaRepository<PokeUsers, Integer>{
	
	public Optional<List<PokeUsers>> findByName(String name);

}
