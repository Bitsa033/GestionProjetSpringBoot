package com.services.admin_nation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoriteService {
	@Autowired
	private AutoriteRepository autoR;
	
	public List<Autorite> displayData(){
		return autoR.findAll();
		
	}
	
	public void saveData(Autorite autorite) {
		Autorite auto=new Autorite(autorite.getId(),autorite.getNom(),autorite.getType());
		autoR.save(auto);
	}
	
	public Optional<Autorite> findDataById(String id) {
		return autoR.findById(id);
			
	}
	
	public void updateData(String id, String nom, String type) {
		Autorite r= autoR.getById(id);
		r.setNom(nom);
		r.setType(type);
		
		autoR.save(r);
	}
	
	public void deleteData(String id) {
		 autoR.deleteById(id);
			
	}

}
