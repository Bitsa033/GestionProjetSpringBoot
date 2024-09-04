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
@RequestMapping("equipe_projet/")
public class EquipeProjetController {
	
	@Autowired
	private EquipeProjetService projetService;
	
	@GetMapping("find_all")
	List<EquipeProjet> find_all() {
		List<EquipeProjet> projets=projetService.displayData();
		return projets;
	}
	
	@PostMapping("save")
	public EquipeProjet save(EquipeProjet equipe) {
		projetService.saveData(equipe);
		return equipe;
	}

	@GetMapping("find/{id}")
	public Optional<EquipeProjet>  find(@PathVariable String id) {
		return projetService.findData(id);
		
	}
	
	@PutMapping("update/{id}")
	public EquipeProjet  update(String id,EquipeProjet equipe) {
		projetService.updateData(id, equipe);
		return equipe;	
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		return projetService.deleteData(id);
	}
		
	}
