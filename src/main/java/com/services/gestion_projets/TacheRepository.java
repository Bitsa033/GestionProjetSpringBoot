package com.services.gestion_projets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TacheRepository extends JpaRepository<Tache, String> {

	@Query(
	        value = "SELECT * FROM tache WHERE MATCH(nom, projet) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Projet> search_data(String keyword);
	@Query(
	        value = "SELECT count(id) from tache;",
	        nativeQuery = true)
	    public String n_b_data();
}
