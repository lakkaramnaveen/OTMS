package com.cg.otms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity//it will specify it as entity class for bean configuration
@Table(name = "user_table")//it map table by name to database
public class User {
	//bean class with good encapsulation 
	//with private fields and public getters and setters
	@Id//primary key
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	//provides the requirements for id generation with name and type
	@SequenceGenerator(name="mygen",sequenceName="user_seq",allocationSize=1)
	//it will specify the sequence
	@Column(name="user_id")//maps the particular column from table
	private long userId ;

	@Column(name="user_name",length=16)//length is mentioned only when we use string
	private String userName ;

	@Column(name="user_test")
	private long userTest ;

	@Column(name="is_admin")
	private boolean isAdmin ;

	@Column(name="user_password",length=16)
	private String userPassword;




	public User() {
		super();
	}

	public User(long userId, String userName, long userTest, boolean isAdmin, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userTest = userTest;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}
	public User( String userName, Long userTest, boolean isAdmin, String userPassword) {
		super();
		this.userName = userName;
		this.userTest = userTest;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}

	//getters and setters
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserTest() {
		return userTest;
	}

	public void setUserTest(long userTest) {
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
