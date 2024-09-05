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
public class Projet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idp;
	private String nom;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "createur")
	private User createur;
	private String date_debut;
	private String date_fin;
	private String statut;
	
	public int getId() {
		return idp;
	}
	public void setId(int id) {
		this.idp = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public User getCreateur() {
		return createur;
	}
	public void setCreateur(User createur) {
		this.createur = createur;
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
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projet(String nom, User createur, String date_debut, String date_fin, String statut) {
		super();
		this.nom = nom;
		this.createur = createur;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.statut = statut;
	}
	

}
