package com.services.admin_nation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Autorite {

	@Id
	private String id;
	private String nom;
	private String type;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Autorite(String id, String nom, String type) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
	}
	
	public Autorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
