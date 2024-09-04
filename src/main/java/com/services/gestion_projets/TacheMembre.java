package com.services.gestion_projets;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class TacheMembre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "membre")
	private User membre;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tache")
	private Tache tache;
	private String date_debut;
	private String date_fin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getMembre() {
		return membre;
	}
	public void setMembre(User membre) {
		this.membre = membre;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	
	public TacheMembre(User membre, Tache tache, String date_debut, String date_fin) {
		super();
		this.membre = membre;
		this.tache = tache;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public TacheMembre() {
		super();
		// TODO Auto-generated constructor stub
	}

}
