package com.saurabh.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy= InheritanceType.JOINED)  //we are creating joined inheritance
public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String role;
	private Address address;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressfk")
	public Address getAddress() {
		return address;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	
	@Column(name = "last_Name")
	public String getLastName() {
		return lastName;
	}
	
	@Column(name = "role")
	public String getRole() {
		return role;
	}
	
	@Column(name = "first_Name")
	public String getFirstName() {
		return firstName;
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	
	@Column(name = "email_Id")
	public String getEmailId() {
		return emailId;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
}
