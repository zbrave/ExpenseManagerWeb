package com.mertaydar.emw.auth;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import com.mertaydar.emw.service.BanDAO;
import com.mertaydar.emw.service.UserDAO;
import com.mertaydar.emw.service.UserRoleDAO;
import com.mertaydar.emw.model.UserInfo;
 
@Service
public class MyDBAuthenticationService implements UserDetailsService {
	
	private static final Logger logger = Logger.getLogger(MyDBAuthenticationService.class);

    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private BanDAO banDAO;
    
    @Autowired
    private UserRoleDAO userRoleDAO;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = this.userDAO.findLoginUserInfo(username);
        
        if (userInfo == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("UserInfo= " + userInfo);
        logger.info(userInfo.toString());
        // [USER,ADMIN,..]
        List<String> roles= userRoleDAO.getUserRoles(userInfo.getId());
         
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
                logger.info("Roles: "+role);
                System.out.println("Yetkiler: "+role);
            }
        }
        
        UserDetails userDetails = buildUserForAuthentication(userInfo, grantList);
        return userDetails;
    }
    
    private User buildUserForAuthentication(UserInfo userInfo,List<GrantedAuthority> authorities) {
    	return new User(userInfo.getUsername(), userInfo.getPassword(),
				userInfo.getEnabled(), true, true, true, authorities);
    }
     
}