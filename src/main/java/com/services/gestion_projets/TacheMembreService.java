package com.services.gestion_projets;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacheMembreService {
	
	@Autowired
	private TacheMembreRepository tacheRepo;
	
	public List<TacheMembre> displayData(){
		List<TacheMembre> data= tacheRepo.findAll();
		return data;
	}
	
	public String nb_data() {
		return tacheRepo.n_b_data();
	}
	
	public void saveData(TacheMembre projet) {
		tacheRepo.save(projet);
	}
	
	public Optional<TacheMembre> findData(String id) {
		Optional<TacheMembre> tache= tacheRepo.findById(id);
		return tache;
	}
	
	public void updateData( String id, TacheMembre tache) {
		Optional<TacheMembre> tache_obj= findData(id);
		TacheMembre data = tache_obj.get();
		data.setTache(tache.getTache());
		data.setMembre(tache.getMembre());
		data.setDate_debut(tache.getDate_debut());
		data.setDate_fin(data.getDate_fin());
		tacheRepo.save(data);
	}
	
	public String deleteData(String id) {
		tacheRepo.deleteById(id);
		return "data deleted ";
	}

}
