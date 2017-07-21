package com.mertaydar.emw.service;

import java.util.List;

import com.mertaydar.emw.entity.Activation;
import com.mertaydar.emw.model.ActivationInfo;

public interface ActivationDAO {
	
	public Activation findActivation(Integer id);
	public Activation findActivationWithUser(Integer id);
	public Activation findActivationWithCode(String code);
	public void saveActivation(Activation act);
	public void deleteActivation(Integer id);
	public List<ActivationInfo> listActivations();
	public void deleteUnusedAccs();
}
