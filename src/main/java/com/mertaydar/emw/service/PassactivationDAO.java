package com.mertaydar.emw.service;

import java.util.List;

import com.mertaydar.emw.entity.RegisterActivation;
import com.mertaydar.emw.model.ForgotPasswordInfo;

public interface PassactivationDAO {
	public RegisterActivation findPassactivation(Integer id);
	public RegisterActivation findPassactivationWithUser(Integer id);
	public RegisterActivation findPassactivationWithCode(String code);
	public void savePassactivation(RegisterActivation act);
	public void deletePassactivation(Integer id);
	public List<ForgotPasswordInfo> listPassactivations();
	void deletePassactivationWithUser(Integer id);
}
