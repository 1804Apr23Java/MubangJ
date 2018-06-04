package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.C_Users;
import com.revature.repository.UserDao;

@RestController("userController")
@RequestMapping("/people")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/users")
	@ResponseBody
	public ResponseEntity<List<C_Users>> getAllUsers() {
		return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ResponseEntity<C_Users> getUserById(@PathVariable int id) {
		ResponseEntity<C_Users> resp = new ResponseEntity<>(userDao.findUserById(id), HttpStatus.OK);
		return resp;
	}
}
