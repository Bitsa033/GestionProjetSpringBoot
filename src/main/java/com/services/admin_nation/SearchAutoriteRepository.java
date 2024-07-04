package com.services.admin_nation;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchAutoriteRepository extends JpaRepository<Autorite, String> {
 
	@Query(
	        value = "SELECT * FROM autorite WHERE MATCH(nom, type) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Autorite> search_autorite(String keyword);
	
	@Query(
	        value = "SELECT count(id) from autorite;",
	        nativeQuery = true)
	    public String n_b_autorite();
     
}
