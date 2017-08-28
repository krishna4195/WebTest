package webtest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import webtest.DbContract;

public class Loginservice {
	public boolean authenticate(String username,String password){
		String query;
	    String dbUsername, dbPassword;
	    
	    try {
	           Class.forName("org.postgresql.Driver");

	              Connection con = DriverManager.getConnection(

	                      DbContract.HOST+DbContract.DB_NAME,

	                      DbContract.USERNAME,

	                      DbContract.PASSWORD);


	              System.out.println("DB connected");
	              Statement stmt = (Statement) con.createStatement();
	              query = "SELECT name, password FROM Registration;";
	              stmt.executeQuery(query);
	              ResultSet rs = stmt.getResultSet();

	              while(rs.next()){
	                  dbUsername = rs.getString("name");
	                  dbPassword = rs.getString("password");
	                  if((dbUsername.trim().equals(username.trim()))&&(dbPassword.trim().equals(password.trim()))){
	                      return true;
	                  }
	              }
	              
	          } catch (ClassNotFoundException e) {
	              e.printStackTrace();
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
		return false;
	}
}
