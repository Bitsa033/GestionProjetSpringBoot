package com.services.admin_nation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
	@Autowired
	private RegionRepository regionR;
	
	public List<Region> displayData(){
		return regionR.findAll();
		
	}
	
	public void saveData(Region region) {
		Region r=new Region(region.getId(),region.getNomRegion(),region.getChefLieu(),region.getSuperficie(),region.getAutorite());
		regionR.save(r);
	}
	
	public Optional<Region> findDataById(String id) {
		return regionR.findById(id);
			
	}
	
	public void updateData(String id, String nom, String superficie, String autorite, String cheflieu) {
		Region r= regionR.getById(id);
		r.setNomRegion(nom);
		r.setSuperficie(superficie);
		r.setAutorite(autorite);
		r.setChefLieu(cheflieu);
		
		regionR.save(r);
	}
	
	public void deleteData(String id) {
		 regionR.deleteById(id);
			
	}

}
