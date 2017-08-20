package com.mertaydar.emw.service;

import java.util.List;
import org.springframework.security.access.annotation.Secured;
import com.mertaydar.emw.entity.User;
import com.mertaydar.emw.entity.UserRole;

public interface IUserRoleService {
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	List<UserRole> getUserRoles(Integer userId); 
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	void addUserRole(User user);

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	void updateUserRole(User user);

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	void deleteUserRole(Integer userRoleId);
}
