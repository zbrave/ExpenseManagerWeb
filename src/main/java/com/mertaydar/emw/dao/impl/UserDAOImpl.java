package com.mertaydar.emw.service.impl;
 
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mertaydar.emw.service.UserRoleDAO;

import com.mertaydar.emw.entity.Activation;
import com.mertaydar.emw.service.ActivationDAO;
import com.mertaydar.emw.service.UserDAO;
import com.mertaydar.emw.model.UserInfo;
import com.mertaydar.emw.model.UserRoleInfo;
import com.mertaydar.emw.entity.User;
 
@Service
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Autowired 
	private ActivationDAO activationDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findUser(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(User.class);
        crit.add(Restrictions.eq("id", id));
        return (User) crit.uniqueResult();
	}

	@Override
	public void saveUser(UserInfo userInfo) {
		Integer id = userInfo.getId();
		User user = null;
		if( id!=null ){
			user = this.findUser(id);
		}
		boolean isNew = false;
		if( user == null ){
			isNew = true;
			user = new User();
			user.setEnabled(false);
			if (!userInfo.getUsername().contains("@")) {
				Activation act = new Activation();
				act.setUsername(userInfo.getUsername());
			    act.setCode(getSaltString());
			    act.setRecordDate(new Date());
			    activationDAO.saveActivation(act);
			    String text = "7/24 Sistem hesabını aktif etmek için aşağıdaki linke tıklayın.\n\n";
			    text = text.concat("http://localhost:8080/sysprog/activate?code="+act.getCode().toString());
			}
		}
		user.setId(userInfo.getId());
	    user.setEmail(userInfo.getEmail());
	    user.setUsername(userInfo.getUsername());
	    user.setPassword(userInfo.getPassword());
	    user.setEnabled(userInfo.getEnabled());
	    if(isNew){
	    	Session session=this.sessionFactory.getCurrentSession();
	    	session.persist(user);
	    }
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

	@Override
	public UserInfo findUserInfo(Integer id) {
		User user = this.findUser(id);
		if(user==null){
			return null;
		}
		return new UserInfo(user.getId(),user.getEmail(),user.getUsername(),user.getPassword(),user.getEnabled());
	}

	@Override
	public void deleteUser(Integer id) {
		User user = this.findUser(id);
		if(user!=null){
			this.sessionFactory.getCurrentSession().delete(user);
		}
		
	}

	@Override
	public User findLoginUser(String username) {
    	Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(User.class);
        crit.add(Restrictions.eq("username", username));
        return (User) crit.uniqueResult();
	}

	@Override
	public UserInfo findLoginUserInfo(String username) {
		User user = this.findLoginUser(username);
        if (user == null) {
            return null;
        }
        return new UserInfo(user.getId(),user.getEmail(),user.getUsername(),user.getPassword(),user.getEnabled());
	}
	
	@Override
	public UserInfo findLoginUserInfoWithEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(User.class);
        crit.add(Restrictions.eq("email", email));
        User user = (User) crit.uniqueResult();
        if (user == null) {
            return null;
        }
        return new UserInfo(user.getId(),user.getEmail(),user.getUsername(),user.getPassword(),user.getEnabled());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> listUserInfos() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(User.class);
        List<User> users =(List<User>) crit.list();
        List<UserInfo> userInfos=new ArrayList<UserInfo>();
        for(User u : users){
        	userInfos.add((UserInfo)findUserInfo(u.getId()));
        }
        return userInfos;
	}

	@Override
	public List<UserInfo> listUserInfosPagination(Integer offset, Integer maxResults) {
		List<UserInfo> fullList=listUserInfos();
        List<UserInfo> offsetList=new ArrayList<UserInfo>();
        maxResults = maxResults!=null?maxResults:10;
        offset = (offset!=null?offset:0);
        for(int i=0; i<maxResults && offset+i<fullList.size(); i++){
        	offsetList.add(fullList.get(offset+i));
        }
        return offsetList;
	}
	
	@Override
	public Long count() {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(User.class);
        crit.setProjection(Projections.rowCount());
        return (Long) crit.uniqueResult();
	}
}