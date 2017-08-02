package com.mertaydar.emw.model;

public class UserInfo {
	
	private Integer id;
	private String name;
    private String username;
    private String password;
    private String passwordConf;
    private String email;
    private String isOnline;
    private byte[] photo;
    private Boolean enabled;
    
    public UserInfo() {
    	
    }

	public UserInfo(Integer id, String name, String username, String password, String passwordConf, String email,
			String isOnline, byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.passwordConf = passwordConf;
		this.email = email;
		this.isOnline = isOnline;
		this.photo = photo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", passwordConf=" + passwordConf + ", email=" + email + ", isOnline=" + isOnline + "]";
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
    
   

}