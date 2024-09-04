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
@RequestMapping("tache_membre_equipe_projet/")
public class TacheMembreController {
	
	@Autowired
	private TacheMembreService tacheService;
	
	@GetMapping("find_all")
	List<TacheMembre> find_all() {
		List<TacheMembre> taches=tacheService.displayData();
		return taches;
	}
	
	@PostMapping("save")
	public TacheMembre  save(TacheMembre tache) {
		TacheMembre data = new TacheMembre(tache.getMembre(), tache.getTache(), tache.getDate_debut(),tache.getDate_fin());
		tacheService.saveData(data);
		return data;
	}

	@GetMapping("find/{id}")
	public Optional<TacheMembre>  find(@PathVariable String id) {
		return tacheService.findData(id);
		
	}
	
	@PutMapping("update/{id}")
	public TacheMembre update(String id, TacheMembre tache) {
		tacheService.updateData(id,tache);
		return tache;
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		return tacheService.deleteData(id);
	}
		
	}
