package com.cg.otms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.otms.dao.IUserDao;
import com.cg.otms.entity.User;
import com.cg.otms.exception.OtmsException;


@Service//it will let the webapplcationcontext to create a bean class for it as a component
//it indicates the class as a service class
public class UserServiceImpl implements IUserService {


	private String str = "NOT FOUND";
	// inorder to achieve loose coupling as we can have many implementation objects
	// from one service

	// dao object will be injected into service while creating controller in
	// WebApplicationContext
	@Autowired
	IUserDao userDao;

	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}
	// we implement abstract classes from service interface by overriding those
	// methods so that we write our own code

	@Override
	public List<User> getAllUsers() throws OtmsException {
		// it will call the method from user dao interface and will return list of
		// users
		return userDao.findAll();
	}

	@Override
	public User getUserByName(String userName) throws OtmsException {
		if (userDao.getUserByName(userName)==null) {
			throw new OtmsException(str);
			// it is handled by global exception handler
		}
		return userDao.getUserByName(userName);//dao method will be invoked
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