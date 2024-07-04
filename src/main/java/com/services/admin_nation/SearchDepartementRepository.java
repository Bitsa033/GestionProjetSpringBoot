package com.services.admin_nation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchDepartementRepository extends JpaRepository<Departement, String> {
	
	@Query(
	        value = "SELECT * FROM departement WHERE MATCH(nom_dep,superficie,chef_lieu, autorite) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Departement> search_departement(String keyword);
	
	@Query(
	        value = "SELECT count(id) from departement;",
	        nativeQuery = true)
	    public String n_b_departement();

}
