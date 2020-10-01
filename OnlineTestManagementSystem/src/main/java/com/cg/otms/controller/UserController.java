package com.cg.otms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.otms.entity.User;
import com.cg.otms.exception.OtmsException;
import com.cg.otms.service.IUserService;


@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	IUserService service;

	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<>(service.addUser(user),HttpStatus.OK);
	}
	
	@GetMapping("/users/all")
	public ResponseEntity<List<User>> getAllUsers() throws OtmsException{
		return new ResponseEntity<List<User>>(service.getAllUsers(),HttpStatus.OK) ;
	}
	
	@GetMapping("/user/user-name/{userName}")
	public User getUserByName(@PathVariable String userName) throws OtmsException {
		return service.getUserByName(userName);
	}
	
	@GetMapping("/user/admin/{userName}/{userPassword}")
	public ResponseEntity<Boolean> validateAdmin(@PathVariable String userName, @PathVariable String userPassword) throws OtmsException {
		boolean valid =  service.validateAdmin(userName,userPassword);
		return new ResponseEntity<Boolean>(valid,HttpStatus.ACCEPTED);
	}
	@GetMapping("/user/{userName}/{userPassword}")
	public ResponseEntity<Boolean> validateUser(@PathVariable String userName, @PathVariable String userPassword) throws OtmsException {
		boolean valid =  service.validateUser(userName,userPassword);
		return new ResponseEntity<Boolean>(valid, HttpStatus.ACCEPTED);
	}
	

}
