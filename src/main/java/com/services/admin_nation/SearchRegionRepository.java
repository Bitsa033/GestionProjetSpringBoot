package com.services.admin_nation;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRegionRepository extends JpaRepository<Region, String> {
 
	@Query(
	        value = "SELECT * FROM region WHERE MATCH(nom_region, chef_lieu) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Region> search_region(String keyword);
	@Query(
	        value = "SELECT count(id) from region;",
	        nativeQuery = true)
	    public String n_b_region();
     
}
