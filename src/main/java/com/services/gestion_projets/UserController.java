package com.services.gestion_projets;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class UserController {
	
	@Autowired
	private UsersService servicesUsers;
	
	@GetMapping("find_all")
	List<User> find_all() {
		List<User> users=servicesUsers.displayData();
		return users;
	}
	
	@PostMapping("save")
	public User  save(String username, String email, String password) {
		User userData=new User(username,email,password);
		servicesUsers.saveData(userData);
		return userData;
		
	}

	@GetMapping("find/{id}")
	public Optional<User>  find(@PathVariable String id) {
		
		return servicesUsers.findData(id);
		
	}
	
	@PutMapping("update/{id}")
	public User  updata_user(String username, String email, String password) {
		User userData=new User(username,email,password);
		servicesUsers.saveData(userData);
		return userData;
		
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		return servicesUsers.deleteData(id);
		
	}
	

}
