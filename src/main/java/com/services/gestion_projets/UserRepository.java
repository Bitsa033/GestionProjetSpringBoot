package com.services.gestion_projets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query(
	        value = "SELECT username FROM user WHERE username=?1;",
	        nativeQuery = true)
	    public User find_name(String name);
	@Query(
	        value = "SELECT count(idu) from user;",
	        nativeQuery = true)
	    public String n_b_data();
}
