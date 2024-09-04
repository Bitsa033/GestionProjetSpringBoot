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
@RequestMapping("projet/")
public class ProjetController {
	
	@Autowired
	private ProjetService projetService;
	
	@GetMapping("find_all")
	List<Projet> find_all() {
		List<Projet> projets=projetService.displayData();
		return projets;
	}
	
	@PostMapping("save")
	public Projet  save(Projet projet) {
		projetService.saveData(projet);
		return projet;
		
	}

	@GetMapping("find/{id}")
	public Optional<Projet>  find(@PathVariable String id) {
		
		return projetService.findData(id);
		
	}
	
	@PutMapping("update/{id}")
	public Projet  updata_user(String id,Projet projet) {
		projetService.updateData(id,projet);
		return projet;
		
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		return projetService.deleteData(id);
	}
		
	}
