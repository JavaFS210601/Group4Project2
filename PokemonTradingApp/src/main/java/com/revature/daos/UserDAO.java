package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.PokeUsers;

public interface UserDAO extends JpaRepository<PokeUsers, Integer>{

}
