package com.services.gestion_projets;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> displayData(){
		List<User> data= userRepo.findAll();
		return data;
	}
	
	public void saveData(User user) {
		userRepo.save(user);
	}
	
	public Optional<User> findData(String id) {
		Optional<User> user= userRepo.findById(id);
		
		return user;
		
	}
	
	public void updateData( String id, User user) {
		Optional<User> user_obj= findData(id);
		User user_data= user_obj.get();
		user_data.setUsername(user.getUsername());
		user_data.setEmail(user.getEmail());
		
		userRepo.save(user_data);
	}
	
	public void updatePassword( String id, String password) {
		Optional<User> user_obj= findData(id);
		User user_data= user_obj.get();
		user_data.setPassword(password);
		
		userRepo.save(user_data);
	}
	
	public String deleteData(String id) {
		userRepo.deleteById(id);
		return "data deleted ";
	}
	
	public User findDataByName(String nameRequest) {
		// TODO Auto-generated method stub
		return userRepo.find_name(nameRequest);
	}

	public String nb_data() {
		// TODO Auto-generated method stub
		return userRepo.n_b_data();
	}
	
	


}
