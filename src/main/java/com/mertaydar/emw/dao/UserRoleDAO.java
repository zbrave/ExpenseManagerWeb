package com.mertaydar.emw.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mertaydar.emw.entity.User;
import com.mertaydar.emw.entity.UserRole;

@Repository
@Transactional
public class UserRoleDAO implements IUserRoleDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getUserRoles(Integer userId) {

		String hql = "FROM UserRole as usr WHERE usr.user.id = ?";
		List<UserRole> userRoles = (List<UserRole>) hibernateTemplate.find(hql, userId);
		
		return userRoles;
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