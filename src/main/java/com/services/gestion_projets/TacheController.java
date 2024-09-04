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
@RequestMapping("tache/")
public class TacheController {
	
	@Autowired
	private TacheService tacheService;
	
	@GetMapping("find_all")
	List<Tache> find_all() {
		List<Tache> taches=tacheService.displayData();
		return taches;
	}
	
	@PostMapping("save")
	public Tache  save(Tache tache) {
		Tache data = new Tache(tache.getNom(), tache.getProjet(), tache.getStatut());
		tacheService.saveData(data);
		return data;
	}

	@GetMapping("find/{id}")
	public Optional<Tache>  find(@PathVariable String id) {
		
		return tacheService.findData(id);
		
	}
	
	@PutMapping("update/{id}")
	public Tache  update(String id,Tache tache) {
		tacheService.updateData(id, tache);
		return tache;
		
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		return tacheService.deleteData(id);
	}
		
	}
