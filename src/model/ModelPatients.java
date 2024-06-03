package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ModelPatients {
	
	
	ModelConnectDB modelConnect = new ModelConnectDB();
	Connection connect = modelConnect.connectDB();
	
	public ResultSet getData() {		 
		ResultSet result = null;
	    try {
	        Connection connect = modelConnect.connectDB();
	        String sql = "SELECT * FROM pacients";
	        PreparedStatement sta = connect.prepareStatement(sql);
	        result = sta.executeQuery();
	      
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; 
	    }

	    return result;
	  }
	
	public boolean searchPatient(String dni) {
		try {
			Connection connect = modelConnect.connectDB();
			String sql = "SELECT COUNT(*) FROM pacients Where dni = ?";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, dni);
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
	
	public ResultSet getPatient(String dni) {
	    try {
	    	String sql = "SELECT firstname, lastname, borndate, telephone, address, dni FROM pacients WHERE dni = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, dni);
            return statement.executeQuery();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; 
	    }
	}

	  public void addUser(String firstname,String lastname,String bornDate, String telephone, String address,String dni) {
		try {
			String sql = "INSERT INTO pacients (id,firstname,lastname,borndate,telephone,address,dni) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement sta = connect.prepareStatement(sql);
			
			sta.setInt(1, 0);
			sta.setString(2, firstname);
			sta.setString(3,lastname);
			sta.setString(4,bornDate);
			sta.setString(5,telephone);
			sta.setString(6,address);
			sta.setString(7,dni);
			
			sta.executeUpdate();
			
			System.out.println("Cool");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	  }
	  
	  public boolean editUser(String dni, String firstname, String lastname, String borndate, String telephone, String address) throws SQLException {
		    try (Connection connect = modelConnect.connectDB()) {
		        String sql = "UPDATE pacients SET firstname = ?, lastname = ?, borndate = ?, telephone = ?, address = ? WHERE dni = ?";
		        PreparedStatement statement = connect.prepareStatement(sql);

		        statement.setString(1, dni);
		        statement.setString(2, firstname);
		        statement.setString(3, lastname);  
		        statement.setString(4, borndate);
		        statement.setString(5, telephone);
		        statement.setString(6, address);  

		        int rowsUpdated = statement.executeUpdate();

		        if (rowsUpdated > 0) {
		            return true;
		        } else {
		            return false;
		        }
		    } catch (SQLException e) {
		        throw e; 
		    }
		}
	  
	  public boolean deletePatient(String dni) {
		  try {
			  Connection connect = modelConnect.connectDB();
			  String sql = "DELETE FROM pacients where dni = ?";
			  PreparedStatement sta = connect.prepareStatement(sql);
			  sta.setString(1, dni);
			  int rowsUpdate = sta.executeUpdate();
			  if(rowsUpdate > 0) {
				  return true;
			  }else {
				  return false;
			  }
			  
		  }catch(Exception e) {
			  e.printStackTrace();
			  return false;
		  }
	  }
	  
	  
}
