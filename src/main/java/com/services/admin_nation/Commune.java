package com.services.admin_nation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Commune {
	
	@Id
	private String id;
	private String nom;
	private String autorite;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getAutorite() {
		return autorite;
	}
	
	public void setAutorite(String autorite) {
		this.autorite = autorite;
	}
	
	public Commune(String id, String nom, String autorite) {
		super();
		this.id = id;
		this.nom = nom;
		this.autorite = autorite;
	}
	
	public Commune() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
