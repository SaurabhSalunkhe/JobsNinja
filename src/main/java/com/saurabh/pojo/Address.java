package com.saurabh.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	private int id;
	private User user;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zip;
	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="address")
	public User getUser() {
		return user;
	}
	
	@Column(name="street")
	public String getStreet() {
		return street;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}
	
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	
	@Column(name="zip")
	public String getZip() {
		return zip;
	}
	
	@Column(name="state")
	public String getState() {
		return state;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	

}
