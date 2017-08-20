package com.mertaydar.emw.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 45, nullable = false)
	private String name;
	
	@Column(name = "username",unique = true, length = 20, nullable = false)
    private String username;
	
	@Column(name = "password", length = 60, nullable = false)
    private String password;
	
	@Column(name = "email", unique = true, length = 100, nullable = false)
    private String email;
	
	@Column(name = "is_online", nullable = false, columnDefinition = "boolean default false")
    private boolean isOnline;
	
	@Column(name = "photo", nullable = false)
    private byte[] photo;
	
	@Column(name = "enabled", nullable = false)
    private Boolean enabled = false;
	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<UserRole> roles;
//	
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	private ForgotPassword forgotPassword;
//    
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	private RegisterActivation registerActivation;
//	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<Message> outbox;
//	
//	@OneToMany(mappedBy = "toUser", cascade = CascadeType.ALL)
//	private List<Message> inbox;
//	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<House> houses;
//	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<BanHistory> banHistory;
//	
//	public List<BanHistory> getBanHistory() {
//		return banHistory;
//	}
//
//	public void setBanHistory(List<BanHistory> banHistory) {
//		this.banHistory = banHistory;
//	}
//
//	public List<Account> getAccounts() {
//		return accounts;
//	}
//
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<Account> accounts;
//	
//	public List<House> getHouses() {
//		return houses;
//	}
//
//	public void setHouses(List<House> houses) {
//		this.houses = houses;
//	}
//
//	public ForgotPassword getForgotPassword() {
//		return forgotPassword;
//	}
//
//	public void setForgotPassword(ForgotPassword forgotPassword) {
//		this.forgotPassword = forgotPassword;
//	}
//
//	public RegisterActivation getRegisterActivation() {
//		return registerActivation;
//	}
//
//	public void setRegisterActivation(RegisterActivation registerActivation) {
//		this.registerActivation = registerActivation;
//	}
//
//	public List<Message> getOutbox() {
//		return outbox;
//	}
//
//	public void setOutbox(List<Message> outbox) {
//		this.outbox = outbox;
//	}
//
//	public List<Message> getInbox() {
//		return inbox;
//	}
//
//	public void setInbox(List<Message> inbox) {
//		this.inbox = inbox;
//	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
//	public List<UserRole> getRoles() {
//		return roles;
//	}
//	
//	public void setRoles(List<UserRole> roles) {
//		this.roles = roles;
//	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
}
