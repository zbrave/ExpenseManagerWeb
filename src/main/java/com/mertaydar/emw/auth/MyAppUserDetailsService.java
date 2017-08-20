package com.mertaydar.emw.auth;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mertaydar.emw.dao.IUserDAO;

@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		com.mertaydar.emw.entity.User activeUserInfo = userDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");//activeUserInfo.get());
		UserDetails userDetails = (UserDetails)new User(activeUserInfo.getUsername(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
} 
