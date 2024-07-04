package com.services.admin_nation;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {
	
	@Autowired
	private UsersService servicesUsers;
	
	AdministrationCamerounApplication va= new AdministrationCamerounApplication();
	
	@GetMapping("all_users")
	String all_users(Model model) {
		List<User> users=servicesUsers.displayData();
		model.addAttribute("voitures", users);
		return "users/all_users";
	}
	
	@GetMapping("/")
	public String  login(Model model) {
		User user= new User();
		model.addAttribute("user", user);
		return "index";
		
	}
	
	@PostMapping("loginCheck")
	public RedirectView  loginCheck(@ModelAttribute("user")User user) {
		String nameRequest=user.getUsername();
		String passwordRequest=user.getPassword();
		User userDb=servicesUsers.findDataByName(nameRequest);
		
		if (userDb ==null) {
			return new RedirectView("/");
		}
		else {
			String userName=userDb.getUsername();
			String userPassword=userDb.getPassword();
			
			if (nameRequest.equals(userName) && passwordRequest.equals(userPassword)) {
				
				return new RedirectView("findAll_data_regions");
			}
			
			else {
				return new RedirectView("/");
			}
			
		}
		
	}
	
	@GetMapping("logout")
	public RedirectView  logout() {
		return new RedirectView("login");
		
	}
	
	@GetMapping("register")
	public String  register(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		return "users/register";
		
	}
	
	@PostMapping("saveUser")
	public RedirectView  saveUser(@ModelAttribute("user") User user) {
		String id= va.genererID();
		User userData=new User(id,user.getUsername(),user.getEmail(),user.getPassword(),user.getImageName(),user.getImageUrl());
		System.out.println(user.getEmail());
		
		servicesUsers.saveData(userData);
		return new RedirectView("users/all_users");
		
	}

	@GetMapping("edit_user")
	public String  edit_vehicule(Model model,String id) {
		//Optional<Voiture> voiture= vr.findById(id);
		//model.addAttribute("voiture", voiture);
		return "users/edit_user";
		
	}
	
	@GetMapping("delete_user")
	public String  delete_user(Model model) {
		User user= new User();
		model.addAttribute("user", user);
		return "users/delete_user";
		
	}
	
	@PostMapping("delete_user_action")
	public RedirectView delete_user_action(@ModelAttribute("user") User user) {
		String u_id=user.getId();
		servicesUsers.deleteData(u_id);
		return new RedirectView("all_users");
		
	}
	

}
