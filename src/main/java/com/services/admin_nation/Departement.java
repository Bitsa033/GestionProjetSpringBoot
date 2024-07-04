package com.services.admin_nation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Departement {
	@Id
	private String id;
	private String nomDep;
	private String superficie;
	private String chefLieu;
	private String autorite;
	private String region;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	
	public String getChefLieu() {
		return chefLieu;
	}
	
	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}
	
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	public String getSuperficie() {
		return superficie;
	}
	
	public String getAutorite() {
		return autorite;
	}
	public void setAutorite(String autorite) {
		this.autorite = autorite;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public Departement(String id, String nomDep, String chefLieu, String superficie, String autorite, String region ) {
		super();
		this.id = id;
		this.nomDep = nomDep;
		this.chefLieu=chefLieu;
		this.superficie=superficie;
		this.autorite = autorite;
		this.region=region;
	}
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
