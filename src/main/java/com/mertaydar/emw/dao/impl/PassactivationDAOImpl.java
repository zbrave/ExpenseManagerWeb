package com.mertaydar.emw.service.impl;

import com.mertaydar.emw.service.PassactivationDAO;
import com.mertaydar.emw.service.UserDAO;
import com.mertaydar.emw.entity.RegisterActivation;
import com.mertaydar.emw.model.ForgotPasswordInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


public class PassactivationDAOImpl implements PassactivationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
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
	public RegisterActivation findPassactivation(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(RegisterActivation.class);
        crit.add(Restrictions.eq("id", id));
        return (RegisterActivation) crit.uniqueResult();
	}
	
	@Override
	public RegisterActivation findPassactivationWithCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(RegisterActivation.class);
        crit.add(Restrictions.eq("code", code));
        return (RegisterActivation) crit.uniqueResult();
	}
	
	@Override
	public RegisterActivation findPassactivationWithUser(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(RegisterActivation.class);
        crit.add(Restrictions.eq("userId", id));
        return (RegisterActivation) crit.uniqueResult();
	}
	
	@Override
	public void savePassactivation(RegisterActivation act) {
		Integer id = act.getId();
		RegisterActivation actv = null;
		if( id!=null ){
			actv = this.findPassactivation(id);
		}
		boolean isNew = false;
		if( actv == null ){
			isNew = true;
			actv = new RegisterActivation();
		}
		actv.setId(act.getId());
	    actv.setCode(act.getCode());
	    actv.setUser(act.getUser());
	    if(isNew){
	    	Session session=this.sessionFactory.getCurrentSession();
	    	session.persist(actv);
	    }
		
	}

	@Override
	public void deletePassactivation(Integer id) {
		RegisterActivation act = this.findPassactivation(id);
		if(act!=null){
			this.sessionFactory.getCurrentSession().delete(act);
		}
	}
	
	@Override
	public void deletePassactivationWithUser(Integer id) {
		RegisterActivation act = this.findPassactivationWithUser(id);
		if(act!=null){
			this.sessionFactory.getCurrentSession().delete(act);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForgotPasswordInfo> listPassactivations() {
	    Session session = sessionFactory.getCurrentSession();
	    Criteria crit = session.createCriteria(RegisterActivation.class);
	    List<RegisterActivation> activations =(List<RegisterActivation>) crit.list();
	    List<ForgotPasswordInfo> activationInfos = new ArrayList<ForgotPasswordInfo>();
	    for(RegisterActivation b : activations){
	    	activationInfos.add(new ForgotPasswordInfo(b.getId(), b.getUser(), b.getCode(), new Date()));
	    }
	    return activationInfos;
	}
}
