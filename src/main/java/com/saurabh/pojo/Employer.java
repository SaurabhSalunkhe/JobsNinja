package com.saurabh.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employer")
@PrimaryKeyJoinColumn(name="userid")
public class Employer extends User {

	private String name;
	private String workContact;
	private String description;
	
	@Column(name="workContact")
	public String getWorkContact() {
		return workContact;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	
	public void setWorkContact(String workContact) {
		this.workContact = workContact;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
