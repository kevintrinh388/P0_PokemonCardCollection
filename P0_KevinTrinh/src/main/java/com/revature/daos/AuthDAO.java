package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class AuthDAO {
	
	public boolean login(String username, String password) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			// if anything is returned at all, we know a user exists with that password.
			if(rs.next()) {
				return true;
			}
			
		}
		catch(SQLException e) {
			System.out.println("LOGIN FAILED");
			e.printStackTrace();
		}
		
		return false;
	}
	
}
