package com.services.gestion_projets;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeProjetService {
	
	@Autowired
	private EquipeProjetRepository projetRepo;
	
	public List<EquipeProjet> displayData(){
		List<EquipeProjet> data= projetRepo.findAll();
		return data;
	}
	
	public String nb_data() {
		return projetRepo.n_b_data();
	}
	
	public void saveData(EquipeProjet projet) {
		projetRepo.save(projet);
	}
	
	public Optional<EquipeProjet> findData(String id) {
		Optional<EquipeProjet> projet= projetRepo.findById(id);
		return projet;
	}
	
	public void updateData( String id, EquipeProjet equipe) {
		Optional<EquipeProjet> projet_obj= findData(id);
		EquipeProjet data = projet_obj.get();
		data.setProjet(equipe.getProjet());
		data.setMembre(equipe.getMembre());
		projetRepo.save(data);
		
	}
	
	public String deleteData(String id) {
		projetRepo.deleteById(id);
		return "data deleted ";
	}

	public List<EquipeProjet> displayDataByname(String name) {
		List<EquipeProjet> equipe= projetRepo.findAllByname(name);
		return equipe;
	}

}
