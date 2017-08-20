package com.mertaydar.emw.dao;

import java.util.List;

import com.mertaydar.emw.entity.User;

public interface IUserDAO {
	
	User getActiveUser(String userName);

	List<User> getAllUsers();

	User getUserById(int userId);
    
	void addUser(User article);
    
	void updateUser(User user);
    
	void deleteUser(int userId);
    
	boolean userExists(String username, String email);
	
} 
