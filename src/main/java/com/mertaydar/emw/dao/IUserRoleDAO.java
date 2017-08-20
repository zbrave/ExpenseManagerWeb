package com.mertaydar.emw.dao;

import java.util.List;

import com.mertaydar.emw.entity.User;
import com.mertaydar.emw.entity.UserRole;

public interface IUserRoleDAO {

	List<UserRole> getUserRoles(Integer userId); 
	
	void addUserRole(User user);

	void updateUserRole(User user);

	void deleteUserRole(Integer userRoleId);
} 
