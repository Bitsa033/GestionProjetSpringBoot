package com.services.admin_nation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrondissementService {
	
	@Autowired
	private ArrondissementRepository ar;
	
	public List<Arrondissement> displayData(){
		return ar.findAll();
		
	}
	
	public void saveData(Arrondissement arr) {
		Arrondissement a=new Arrondissement(arr.getId(),arr.getNom(),arr.getChefLieu(),arr.getAutorite(),arr.getSuperficie(),arr.getDepartement());
		ar.save(a);
	}
	
	public Optional<Arrondissement> findDataById(String id) {
		return ar.findById(id);
			
	}
	
	public void updateData(String id, String nom, String cheflieu, String autorite, String superfice, String departement) {
		Arrondissement r= ar.getById(id);
		r.setNom(nom);
		r.setChefLieu(cheflieu);
		r.setAutorite(autorite);
		r.setSuperficie(superfice);
		r.setDepartement(departement);
		
		ar.save(r);
	}
	
	public void deleteData(String id) {
		 ar.deleteById(id);
			
	}
}
