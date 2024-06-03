package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ModelUser {
	private String username;
	private String password;
	ModelConnectDB modelConnect = new ModelConnectDB();
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
	public boolean userVerify(String username,String password) {
		try {
			Connection connect = modelConnect.connectDB();
			String sql = "SELECT COUNT(*) FROM User Where username = ? and password = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultS = statement.executeQuery();
			
			if(resultS.next()) {
				int count = resultS.getInt(1);
				return count > 0;
			}else {
				return false;
			}			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

	
	
	
}
