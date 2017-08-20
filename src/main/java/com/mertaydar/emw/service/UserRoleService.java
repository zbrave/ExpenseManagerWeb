package com.mertaydar.emw.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mertaydar.emw.dao.IUserRoleDAO;
import com.mertaydar.emw.entity.User;
import com.mertaydar.emw.entity.UserRole;

@Service
public class UserRoleService implements IUserRoleService {

	@Autowired
	private IUserRoleDAO userRoleDAO;

	@Override
	public List<UserRole> getUserRoles(Integer userId) {

		return userRoleDAO.getUserRoles(userId);
	}

	@Override
	public void addUserRole(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserRole(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserRole(Integer userRoleId) {
		// TODO Auto-generated method stub
		
	}

	
} 