package com.services.admin_nation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartementService {

	@Autowired
	private DepartementRepoository deparRe;
	
	public List<Departement> displayData(){
		return deparRe.findAll();
		
	}
	
	public void saveData(Departement depar) {
		Departement auto=new Departement(depar.getId(),depar.getNomDep(),depar.getChefLieu(),depar.getSuperficie(),depar.getAutorite(),depar.getRegion());
		deparRe.save(auto);
	}
	
	public Optional<Departement> findDataById(String id) {
		return deparRe.findById(id);
			
	}
	
	public void updateData(String id, String nom, String superficie, String autorite, String cheflieu) {
		Departement r= deparRe.getById(id);
		r.setNomDep(nom);
		r.setSuperficie(superficie);
		r.setAutorite(autorite);
		r.setChefLieu(cheflieu);
		
		deparRe.save(r);
	}
	
	public void deleteData(String id) {
		deparRe.deleteById(id);
			
	}
}
