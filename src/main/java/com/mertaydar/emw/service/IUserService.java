package com.mertaydar.emw.service;

import java.util.List;
import org.springframework.security.access.annotation.Secured;
import com.mertaydar.emw.entity.User;

public interface IUserService {

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	List<User> getAllUsers();

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	User getUserById(int userId);

	@Secured ({"ROLE_ADMIN"})
	boolean addUser(User user);

	@Secured ({"ROLE_ADMIN"})
	void updateUser(User user);

	@Secured ({"ROLE_ADMIN"})
	void deleteUser(int userId);
}
