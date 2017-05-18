package com.saurabh.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "Applicant")
@PrimaryKeyJoinColumn(name="user_Id")
public class Applicant extends User {
	
	private String contactNumber;
	private Set<Application> applications;
	private CommonsMultipartFile photo;
	private String filename;
	

	@Column(name="file_Name")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Transient
	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}
	
	@Column(name = "contact_Number")
	public String getContactNumber() {
		return contactNumber;
	}
	

	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	public Set<Application> getApplications() {
		return applications;
	}
	
	//if the student changes its education then it should get reflected in main student class also
	//hence mappedBy
	//used mappedBy to prevent creating the third table
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
	

	
}
