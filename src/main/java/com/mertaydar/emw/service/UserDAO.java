package com.mertaydar.emw.service;

import java.util.List;

import com.mertaydar.emw.entity.User;
import com.mertaydar.emw.model.UserInfo;
 
public interface UserDAO {
	
	public User findUser (Integer id); 
	public void saveUser (UserInfo userInfo);
    public UserInfo findUserInfo (Integer id);  
    public void deleteUser (Integer id);
    
    public User findLoginUser(String username);
    public UserInfo findLoginUserInfo(String username);
    public List<UserInfo> listUserInfos();
    public List<UserInfo> listUserInfosPagination(Integer offset, Integer maxResults);
    public Long count();
	UserInfo findLoginUserInfoWithEmail(String username);
}