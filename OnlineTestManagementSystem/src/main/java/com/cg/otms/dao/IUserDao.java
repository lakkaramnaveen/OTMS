
package com.cg.otms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.otms.entity.User;

public interface IUserDao extends JpaRepository<User,String> {
	@Query(value = "from User where userName=:userName")
	public User getUserByName(String userName);
}

