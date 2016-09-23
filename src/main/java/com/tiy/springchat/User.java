package com.tiy.springchat;

import javax.persistence.*;

/**
 * Created by Brett on 9/23/16.
 */

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	int id;

	@Column(nullable = false, unique = true)
	String userName;

	@Column(nullable = false)
	String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
}
