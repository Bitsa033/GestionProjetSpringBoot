package com.services.gestion_projets;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacheService {
	
	@Autowired
	private TacheRepository tacheRepo;
	
	public List<Tache> displayData(){
		List<Tache> data= tacheRepo.findAll();
		return data;
	}
	
	public String nb_data() {
		return tacheRepo.n_b_data();
	}
	
	public void saveData(Tache tache) {
		tacheRepo.save(tache);
	}
	
	public Optional<Tache> findData(String id) {
		Optional<Tache> tache= tacheRepo.findById(id);
		return tache;	
	}
	
	public void updateData( String id, Tache tache) {
		Optional<Tache> tache_obj= findData(id);
		Tache data = tache_obj.get();
		data.setNom(tache.getNom());
		data.setProjet(tache.getProjet());
		data.setStatut(tache.getStatut());
		tacheRepo.save(data);
	}
	
	public String deleteData(String id) {
		tacheRepo.deleteById(id);
		return "data deleted ";
	}

}
