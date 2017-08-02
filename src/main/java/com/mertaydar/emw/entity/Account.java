package com.mertaydar.emw.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "house_id", referencedColumnName = "id")
	private House house;
	
	@Column(name = "total", nullable = false)
	private Float total;
	
	@Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
	private Boolean enabled;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Item> items;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL)
	private List<Withdraw> incoming;
	
	@OneToMany(mappedBy = "toAccount", cascade = CascadeType.ALL)
	private List<Withdraw> outgoing;

	public List<Withdraw> getIncoming() {
		return incoming;
	}

	public void setIncoming(List<Withdraw> incoming) {
		this.incoming = incoming;
	}

	public List<Withdraw> getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(List<Withdraw> outgoing) {
		this.outgoing = outgoing;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
