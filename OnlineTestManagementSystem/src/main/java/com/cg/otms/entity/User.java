package com.cg.otms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="user_seq",allocationSize=1)
	@Column(name="user_id")
	private int userId ;
	
	@Column(name="user_name",length=16)
	private String userName ;
	
	@Column(name="user_test")
	private int userTest ;
	
	@Column(name="is_admin")
	private boolean isAdmin ;
	
	@Column(name="user_password",length=16)
	private String userPassword;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserTest() {
		return userTest;
	}

	public void setUserTest(int userTest) {
		this.userTest = userTest;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


}
