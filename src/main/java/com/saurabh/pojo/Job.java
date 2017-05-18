package com.saurabh.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="job")
public class Job {

	private Set<Application> applications;
	private int id;
	private String description;
	private String jobTitle;
	private int positions;
	private User user;			
	private Employer employer;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	public int getId() {
		return id;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	
	@OneToOne
	@JoinColumn(name="employerfk")
	public Employer getEmployer() {
		return employer;
	}
	
	@Column(name="jobTitle")
	public String getJobTitle() {
		return jobTitle;
	}
	
	@Column(name="positions")
	public int getPositions() {
		return positions;
	}
	
	@OneToOne
	@JoinColumn(name="userfk")
	public User getUser() {
		return user;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public void setPositions(int positions) {
		this.positions = positions;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}		
	
	@OneToMany(mappedBy="job",fetch=FetchType.EAGER)
	public Set<Application> getApplications() {
		return applications;
	}
	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
	

}
