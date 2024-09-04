package com.services.gestion_projets;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjetRepository extends JpaRepository<Projet, String> {
	@Query(
	        value = "SELECT * FROM projet WHERE MATCH(nom, createur) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Projet> search_data(String keyword);
	@Query(
	        value = "SELECT count(id) from projet;",
	        nativeQuery = true)
	    public String n_b_data();
	@Query(
	        value = "SELECT * FROM `projet` WHERE 1",
	        nativeQuery = true)
	    public List<Projet> projets();
}
