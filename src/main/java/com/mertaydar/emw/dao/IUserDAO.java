package com.mertaydar.emw.dao;

import java.util.List;

import com.mertaydar.emw.entity.User;

public interface IUserDAO {

	User isUserEnabled(String userName);

	List<User> getAllUsers();

	User getUserById(Integer userId);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(Integer userId);

	boolean userExists(String username, String email);

} 
