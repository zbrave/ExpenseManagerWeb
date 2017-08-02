package com.mertaydar.emw.model;

import java.util.Date;

import com.mertaydar.emw.entity.User;

public class ForgotPasswordInfo {
	
	private Integer id;
	private User user;
	private String code;
	private Date date;
	
	public ForgotPasswordInfo() {
		
	}

	public ForgotPasswordInfo(Integer id, User user, String code, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.code = code;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
