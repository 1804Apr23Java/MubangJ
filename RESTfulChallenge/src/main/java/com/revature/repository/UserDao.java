package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.C_Users;

@Repository
public interface UserDao extends JpaRepository<C_Users, Integer> {
	
	public C_Users findUserById(int id);
}
