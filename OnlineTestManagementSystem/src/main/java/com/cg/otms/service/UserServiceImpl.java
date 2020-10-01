package com.cg.otms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.otms.dao.IUserDao;
import com.cg.otms.entity.User;
import com.cg.otms.exception.OtmsException;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() throws OtmsException {
		return userDao.findAll();
	}

	@Override
	public User getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	@Override
	public boolean validateAdmin(String userName, String userPassword) {

		boolean isValid=false;
		User user=userDao.getUserByName(userName);
		if(user.getUserPassword().equals(userPassword) && user.isAdmin()) {
			isValid=true;
		}
		return isValid;
	}

	@Override
	public boolean validateUser(String userName, String userPassword) {

		boolean isValid=false;
		User user=userDao.getUserByName(userName);
		if(user.getUserPassword().equals(userPassword) && !user.isAdmin()) {
			isValid=true;
		}
		return isValid;
	}

}