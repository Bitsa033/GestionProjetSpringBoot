package com.services.admin_nation;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Region {
	@Id
	private String id;
	private String nomRegion;
	private String chefLieu;
	private String superficie;
	private String autorite;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomRegion() {
		return nomRegion;
	}
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	public String getChefLieu() {
		return chefLieu;
	}
	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}
	
	public String getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	
	public String getAutorite() {
		return autorite;
	}
	
	public void setAutorite(String autorite) {
		this.autorite = autorite;
	}
	
	public Region(String id, String nomRegion, String chefLieu, String superficie, String autorite) {
		super();
		this.id = id;
		this.nomRegion = nomRegion;
		this.chefLieu = chefLieu;
		this.superficie = superficie;
		this.autorite = autorite;
	}
	
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
