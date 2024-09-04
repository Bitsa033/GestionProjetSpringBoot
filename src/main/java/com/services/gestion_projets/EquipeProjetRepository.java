package com.services.gestion_projets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipeProjetRepository extends JpaRepository<EquipeProjet, String> {

	@Query(
	        value = "SELECT * FROM equipe_projet WHERE MATCH(projet, membre) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Projet> search_data(String keyword);
	@Query(
	        value = "SELECT count(id) from equipe_projet;",
	        nativeQuery = true)
	    public String n_b_data();
}
