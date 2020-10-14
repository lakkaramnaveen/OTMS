package com.cg.otms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.otms.entity.User;
import com.cg.otms.exception.OtmsException;
import com.cg.otms.service.IUserService;


@RestController		//controller + responsebody
@CrossOrigin("*")    //to achieve cors -> allows resource sharing between different origins
//integrating with angular it will be useful
public class UserController {
	//loose coupling
	@Autowired// service object will be injected into controller while creating controller in
	// WebApplicationContext
	IUserService userService;
	// we cannot create object to an interface but we can have a reference


	Logger logger = LoggerFactory.getLogger(UserController.class);


	@PostMapping("/user/")
	// post is used when we send data and it will not appear on the url
	// requestbody maps httprequest json format data from the client to the local
	// object user
	public ResponseEntity<User> addUser(@RequestBody User user) throws OtmsException {
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
	}

	// it is request mapping with get method
	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getAllUsers() throws OtmsException{
		// using service we call getAllUsers method which will return
		// we can also return normal list of users object but as it is a web request we use
		// response entity
		// it will contain response body and http status code like 200,404...
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK) ;
	}

	@GetMapping("/user/{userName}")
	// inorder to map a parameter from uri to method parameters we use @pathvariable
	public User getUserByName(@PathVariable String userName) throws OtmsException {
		logger.info("User Name from user");
		return userService.getUserByName(userName);
	}

	@GetMapping("/user/login/admin/{userName}/{userPassword}")
	// inorder to handle it global the exception we use throws declaration
	public ResponseEntity<Boolean> validateAdmin(@PathVariable String userName, @PathVariable String userPassword) throws OtmsException {
		logger.info("Admin Login info logs");
		return new ResponseEntity<>(userService.validateAdmin(userName,userPassword),HttpStatus.ACCEPTED);
	}
	@GetMapping("/user/login/{userName}/{userPassword}")
	public ResponseEntity<Boolean> validateUser(@PathVariable String userName, @PathVariable String userPassword) throws OtmsException {
		logger.info("User Login info logs");
		return new ResponseEntity<>(userService.validateUser(userName,userPassword),HttpStatus.ACCEPTED);
	}
}
