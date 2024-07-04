package com.services.admin_nation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Arrondissement {
	@Id
	private String id;
	private String nom;
	private String ChefLieu;
	private String autorite;
	private String superficie;
	
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
	
	public String getChefLieu() {
		return ChefLieu;
	}
	
	public void setChefLieu(String chefLieu) {
		ChefLieu = chefLieu;
	}
	
	public String getAutorite() {
		return autorite;
	}
	
	public void setAutorite(String autorite) {
		this.autorite = autorite;
	}
	
	public String getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	public Arrondissement(String id, String nom, String chefLieu, String autorite, String superficie) {
		super();
		this.id = id;
		this.nom = nom;
		ChefLieu = chefLieu;
		this.autorite = autorite;
		this.superficie = superficie;
	}

	public Arrondissement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
