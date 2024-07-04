package com.services.admin_nation;

import org.springframework.web.multipart.MultipartFile;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private String id;
	private String username;
	private String email;
	private String password;
	private String imageName;
	private String imageUrl;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public User(String id, String username, String email, String password, String imageName, String imageUrl) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.imageName = imageName;
		this.imageUrl = imageUrl;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
