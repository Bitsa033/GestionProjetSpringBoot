package com.services.admin_nation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query(
	        value = "SELECT name FROM user WHERE name=?1;",
	        nativeQuery = true)
	    public User find_name(String name);
}
