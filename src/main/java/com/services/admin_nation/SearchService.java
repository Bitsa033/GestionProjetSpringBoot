package com.services.admin_nation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
	 @Autowired
	 private SearchRegionRepository searchRegionRepo;
	 @Autowired
	 private SearchAutoriteRepository searchAutoriteRepo;
	 @Autowired
	 private SearchDepartementRepository searchDepartementRepo;
	 @Autowired
	 private SearchArrondissementRepository searchArronRepo;
	
	List<Region> search_region(String keyName) {
		
		return searchRegionRepo.search_region(keyName);
	}
	
    List<Autorite> search_autorite(String keyName) {
		
		return searchAutoriteRepo.search_autorite(keyName);
	}
	
   List<Departement> search_departement(String keyName) {
		
		return searchDepartementRepo.search_departement(keyName);
	}
   
   String nb_region() {
	   return searchRegionRepo.n_b_region();
   }
   
   String nb_departements() {
	   return searchDepartementRepo.n_b_departement();
   }
   
   String nb_autorites() {
	   return searchAutoriteRepo.n_b_autorite();
   }

 List<Arrondissement> search_arrondissement(String key_name) {
	// TODO Auto-generated method stub
	return searchArronRepo.search_arrondissement(key_name);
}
   
   

}
