package com.services.admin_nation;

import java.util.List;


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
		User v= new User(user.getId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getImageName(),user.getImageUrl());
		userRepo.save(v);
	}
	
	public void updateData(User user) {
		user.setUsername(user.getUsername());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		userRepo.save(user);
	}
	
	public void deleteData(String id) {
		userRepo.deleteById(id);
	}

	public User findDataByName(String nameRequest) {
		// TODO Auto-generated method stub
		return userRepo.find_name(nameRequest);
	}

}
