package com.teja.usermanage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teja.usermanage.model.UserDetails;

//for database operations
public class UserDao {
	private String url = "jdbc:mysql://localhost:3306/demo";
	private String uname = "root";
	private String pword = "";
	
	String INSERT_USERS = "INSERT INTO user" + "(name, email, country)" + "(?, ? ,?)";
	String UPDATE_USER = "UPDATE user SET name = ?, email= ?, country= ? where id= ?";
	String SELECT_BY_ID = "SELECT id,name,email,country FROM user WHERE id =  ?";
	String SELECT_ALL_USERS = "SELECT * FROM user";
	String DELETE_USER = "DELETE * FROM user WHERE id = ?";
	
	
	
	//writing a separate common method for connection and reusing it
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, pword);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
		//create or insert user
	public void insertUser(UserDetails user) throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS)){
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
		//update user
	public boolean updateUser(UserDetails user) throws SQLException{
		boolean rowUpdated = false;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)){
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setInt(4, user.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	
		//select user by id
	public UserDetails selectUser(int id) throws SQLException{
		UserDetails user = null;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
			preparedStatement.setInt(1, id);	
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String name= rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new UserDetails(id, name, email, country);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
		//select all users
	public List<UserDetails> selectAllUsers() {
		List<UserDetails> users = new ArrayList<>();
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)){
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new UserDetails(id, name, email, country));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
		//delete user by id
	public boolean deleteUser(int id) {
		boolean rowDeleted = false;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){
			preparedStatement.setInt(1, id);
			
			rowDeleted = preparedStatement.executeUpdate() > 0;
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
