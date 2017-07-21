package com.mertaydar.emw.service;

import java.util.List;

import com.mertaydar.emw.entity.UserRole;
import com.mertaydar.emw.model.UserRoleInfo;

public interface UserRoleDAO {
	
	public UserRole findUserRole (Integer id);
	public void saveUserRole (UserRoleInfo userRoleInfo );
	public UserRoleInfo findUserRoleInfo (Integer id);
	public boolean deleteUserRole(Integer id);
	
	public List<String> getUserRoles(Integer userId);
	public List<UserRoleInfo> listUserRoleInfos();
	public List<UserRoleInfo> listUserRoleInfosPagination(Integer offset, Integer maxResults);
	public Long count();
}
