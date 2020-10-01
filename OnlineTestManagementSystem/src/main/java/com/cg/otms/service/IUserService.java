package com.cg.otms.service;

import java.util.List;

import com.cg.otms.entity.User;
import com.cg.otms.exception.OtmsException;

public interface IUserService {
	public User addUser(User user);
	public User getUserByName(String userName) throws OtmsException;
	public List<User> getAllUsers() throws OtmsException;
	public boolean validateAdmin(String userName, String userPassword) throws OtmsException;
	public boolean validateUser(String userName, String userPassword) throws OtmsException;

}
