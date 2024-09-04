package com.services.gestion_projets;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetService {
	
	@Autowired
	private ProjetRepository projetRepo;
	
	public List<Projet> displayData(){
		List<Projet> data= projetRepo.findAll();
		return data;
	}
	
	public List<Projet> projets(){
		List<Projet> data= projetRepo.projets();
		return data;
	}
	
	public String nb_data() {
		return projetRepo.n_b_data();
	}
	
	public void saveData(Projet projet) {
		projetRepo.save(projet);
	}
	
	public Optional<Projet> findData(String id) {
		Optional<Projet> projet= projetRepo.findById(id);
		return projet;
	}
	
	public void updateData( String id, Projet projet) {
		Optional<Projet> projet_obj= findData(id);
		Projet data= projet_obj.get();
		data.setNom(projet.getNom());
		data.setStatut(projet.getStatut());
		data.setCreateur(projet.getCreateur());
		data.setDate_debut(projet.getDate_debut());
		data.setDate_fin(projet.getDate_fin());
		projetRepo.save(data);
	}
	
	public String deleteData(String id) {
		projetRepo.deleteById(id);
		return "data deleted ";
	}

	
}
