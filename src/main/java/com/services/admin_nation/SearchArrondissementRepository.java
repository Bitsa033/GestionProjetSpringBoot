package com.services.admin_nation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface SearchArrondissementRepository extends JpaRepository<Arrondissement, String> {

	
	@Query(
	        value = "SELECT * FROM arrondissement WHERE MATCH(nom,superficie,chef_lieu, autorite,departement) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Arrondissement> search_arrondissement(String keyword);
	
	@Query(
	        value = "SELECT count(id) from arrondissement;",
	        nativeQuery = true)
	    public String n_b_arrondissement();
}
