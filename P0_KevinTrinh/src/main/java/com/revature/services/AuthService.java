package com.revature.services;

import com.revature.daos.AuthDAO;

public class AuthService {
	AuthDAO aDAO = new AuthDAO();
	
	public String login(String username, String password) {
		
		if(aDAO.login(username, password)) {
			return username; // if username and password get a true, send username back
		}
		return null;
	}
	
	// in a more complete app, we'd have a User class with a bunch of variables that we'd instantiate here
	// but for now we'll just return username
	
}
