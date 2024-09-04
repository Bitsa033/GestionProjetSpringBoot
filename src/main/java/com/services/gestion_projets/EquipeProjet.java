package com.services.gestion_projets;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class EquipeProjet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "projet")
	private Projet projet;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "membre")
	private User membre;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	public User getMembre() {
		return membre;
	}
	public void setMembre(User membre) {
		this.membre = membre;
	}
	public EquipeProjet(Projet projet,User membre) {
		super();
		this.projet = projet;
		this.membre = membre;
	}
	public EquipeProjet() {
		super();
		// TODO Auto-generated constructor stub
	}

}
