package com.saurabh.pojo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Resume {

	private String path;
	private CommonsMultipartFile photo;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public CommonsMultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}

}
