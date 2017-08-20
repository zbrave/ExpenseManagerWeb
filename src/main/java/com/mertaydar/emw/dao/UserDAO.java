package com.mertaydar.emw.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mertaydar.emw.entity.User;

@Repository
@Transactional
public class UserDAO implements IUserDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public User isUserEnabled(String username) {
		
		User activeUser = new User();
		boolean enabled = true;
		List<?> list = hibernateTemplate.find("FROM User WHERE username=? and enabled=?",
				username, enabled);
		
		if(!list.isEmpty()) {
			activeUser = (User)list.get(0);
		}
		
		return activeUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		String hql = "FROM User as usr ORDER BY usr.id";
		
		return (List<User>) hibernateTemplate.find(hql);
	}

	@Override
	public User getUserById(Integer userId) {
		
		return hibernateTemplate.get(User.class, userId);
	}

	@Override
	public void addUser(User user) {
		
		hibernateTemplate.save(user);
	}

	@Override
	public void updateUser(User user) {

		User usr = getUserById(user.getId());
		usr.setEmail(user.getEmail());
		usr.setEnabled(user.getEnabled());
		usr.setName(user.getName());
		usr.setPassword(user.getPassword());
		usr.setPhoto(user.getPhoto());
		usr.setUsername(user.getUsername());
		hibernateTemplate.update(usr);
	}

	@Override
	public void deleteUser(Integer userId) {
		
		hibernateTemplate.delete(getUserById(userId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean userExists(String username, String email) {
		
		String hql = "FROM User as usr WHERE usr.username = ? and usr.email = ?";
		List<User> users = (List<User>) hibernateTemplate.find(hql, username, email);
		
		return users.size() > 0 ? true : false;
	}
} 