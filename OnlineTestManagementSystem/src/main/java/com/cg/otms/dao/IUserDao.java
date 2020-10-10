
package com.cg.otms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.otms.entity.User;

public interface IUserDao extends JpaRepository<User,Long>  {
	@Query(value = "from User where userName=:userName")
	//jpa query is executed it is called by service impl methods
	public User getUserByName(String userName) ;
	//user defined method that jpa implements

	//the internal methods are implemented by spring data jpa
}

