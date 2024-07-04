package com.services.admin_nation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UtilisateurController {
	
	@Autowired
	private RegionService servicesRegions;
	@Autowired
	private DepartementService servicesDep;
	@Autowired
	private AutoriteService servicesAutorite;
	@Autowired
	private SearchService serviceSearch;
	
	AdministrationCamerounApplication adminCam= new AdministrationCamerounApplication();
	
	@GetMapping("findAll_data_regions_user")
	public String findAll_data_regions_user(Model model) {
		List<Region> regions=servicesRegions.displayData();
		if (regions.isEmpty()) {
			Region c= new Region(adminCam.genererID(),"Centre","yaoundé","","Paul Naseri Bea");
			Region e= new Region(adminCam.genererID(),"Est","bertoua","","Grégoire Mvongo");
			Region e_n= new Region(adminCam.genererID(),"Extrème-nord","maroua","","Midjiyawa Bakary");
			Region s= new Region(adminCam.genererID(),"Sud","ebolova","","Felix Nguele Nguele");
			Region a= new Region(adminCam.genererID(),"Adamaoua","ngaounderé","","Kildadi Taguieke Boukar");
			Region ne= new Region(adminCam.genererID(),"Nord-ouest","bamenda","","Adolphe Lele Lafrique");
			Region n= new Region(adminCam.genererID(),"Nord","garoua","","Abate Edi'i Jean");
			Region se= new Region(adminCam.genererID(),"Sud-ouest","buéa","","Bernard Okalia  Bilai");
			Region l= new Region(adminCam.genererID(),"Littoral","douala","","Samuel Ivaha Diboua");
			Region o= new Region(adminCam.genererID(),"Ouest","baffoussam","","Augustine Awa Fonka");
			servicesRegions.saveData(c);
			servicesRegions.saveData(e);
			servicesRegions.saveData(e_n);
			servicesRegions.saveData(s);
			servicesRegions.saveData(a);
			servicesRegions.saveData(ne);
			servicesRegions.saveData(n);
			servicesRegions.saveData(se);
			servicesRegions.saveData(l);
			servicesRegions.saveData(o);
			
			
			return "administrateur/regions/findAll_data";
		}
		
		String nb_r=serviceSearch.nb_region();
		Search search= new Search();
		model.addAttribute("region", search);
		model.addAttribute("regions", regions);
		model.addAttribute("nb", nb_r);
		return "utilisateur/regions/findAll_data";
	}
	
	@GetMapping("print_data_regions_user")
	public String print_data_regions_user(Model model) {
		List<Region> regions=servicesRegions.displayData();
		String nb_r=serviceSearch.nb_region();
		model.addAttribute("regions", regions);
		model.addAttribute("nb", nb_r);
		return "utilisateur/regions/print_data";
	}
	
	@GetMapping("findAll_data_departements_user")
	public String findAll_data_departemens_user(Model model) {
		List<Departement> departements=servicesDep.displayData();
		if (departements.isEmpty()) {
			Departement c= new Departement(adminCam.genererID(),"Mfoundi","yaoundé","","","Centre");
			Departement e= new Departement(adminCam.genererID(),"Mefou et Afamba","Mfou","","","Centre");
			Departement e_n= new Departement(adminCam.genererID(),"Mefou et Akono","Ngoumou","","","Centre");
			Departement s= new Departement(adminCam.genererID(),"Haute sanaga","Nanga Eboko","","","Centre");
			Departement a= new Departement(adminCam.genererID(),"Lékié","Monatelé","","","Centre");
			Departement ne= new Departement(adminCam.genererID(),"Mbam et Inoubou","Bafia","","Absalom Woloa","Centre");
			Departement n= new Departement(adminCam.genererID(),"Mbam et Kim","Ntsui","","Irenée Ngalim Ngong","Centre");
			Departement se= new Departement(adminCam.genererID(),"Nyong et Kéllé","Eseka","","","Centre");
			Departement l= new Departement(adminCam.genererID(),"Nyon et Mfoumou","Akonolinga","","Ernest Samuel Christian Ebelle","Centre");
			Departement o= new Departement(adminCam.genererID(),"Nyon et So'o","Mbalmayo","","Pierre René Songa","Centre");
			servicesDep.saveData(c);
			servicesDep.saveData(e);
			servicesDep.saveData(e_n);
			servicesDep.saveData(s);
			servicesDep.saveData(a);
			servicesDep.saveData(ne);
			servicesDep.saveData(n);
			servicesDep.saveData(se);
			servicesDep.saveData(l);
			servicesDep.saveData(o);
			
			
			return "redirect:findAll_data_departements_user";
		}
		String nb_d=serviceSearch.nb_departements();
		Search search= new Search();
		model.addAttribute("departements", departements);
		model.addAttribute("nb", nb_d);
		model.addAttribute("departement", search);
		return "utilisateur/departements/findAll_data";
	}
	
	@GetMapping("print_data_departements_user")
	public String print_data_departements_user(Model model) {
		List<Departement> depaartements=servicesDep.displayData();
		String nb_d=serviceSearch.nb_departements();
		model.addAttribute("departements", depaartements);
		model.addAttribute("nb", nb_d);
		return "utilisateur/departements/print_data";
	}
	
	@GetMapping("findAll_data_autorites_user")
	public String findAll_data_autorites_user(Model model) {
		Search search= new Search();
		String nb_d=serviceSearch.nb_autorites();
		model.addAttribute("autorite", search);
		List<Autorite> autorites=servicesAutorite.displayData();
		if (autorites.isEmpty()) {
			Autorite c= new Autorite(adminCam.genererID(),"Paul Naseri Bea","Gouverneur");
			Autorite e= new Autorite(adminCam.genererID(),"Grégoire Mvongo","Gouverneur");
			Autorite e_n= new Autorite(adminCam.genererID(),"Midjiyawa Bakary","Gouverneur");
			Autorite s= new Autorite(adminCam.genererID(),"Felix Nguele Nguele","Gouverneur");
			Autorite a= new Autorite(adminCam.genererID(),"Kildadi Taguieke Boukar","Gouverneur");
			Autorite ne= new Autorite(adminCam.genererID(),"Adolphe Lele Lafrique","Gouverneur");
			Autorite n= new Autorite(adminCam.genererID(),"Abate Edi'i Jean","Gouverneur");
			Autorite se= new Autorite(adminCam.genererID(),"Bernard Okalia  Bilai","Gouverneur");
			Autorite l= new Autorite(adminCam.genererID(),"Samuel Ivaha Diboua","Gouverneur");
			Autorite o= new Autorite(adminCam.genererID(),"Augustine Awa Fonka","Gouverneur");
			servicesAutorite.saveData(c);
			servicesAutorite.saveData(e);
			servicesAutorite.saveData(e_n);
			servicesAutorite.saveData(s);
			servicesAutorite.saveData(a);
			servicesAutorite.saveData(ne);
			servicesAutorite.saveData(n);
			servicesAutorite.saveData(se);
			servicesAutorite.saveData(l);
			servicesAutorite.saveData(o);
		
			return "redirect:findAll_data_autorites_user";
		}
		model.addAttribute("autorites", autorites);
		model.addAttribute("nb", nb_d);
		return "utilisateur/autorites/findAll_data";
	}
	
	@GetMapping("print_data_autorites_user")
	public String print_data_autorites_user(Model model) {
		String nb_d=serviceSearch.nb_autorites();
		List<Autorite> autorites=servicesAutorite.displayData();
		model.addAttribute("autorites", autorites);
		model.addAttribute("nb", nb_d);
		return "utilisateur/autorites/print_data";
	}
	
	// Méthodes pour les recherches
	
	@GetMapping("recherche_par_region_user")
	String recherche_par_region(Model model, @ModelAttribute("region") Search search) {
		String key_name=search.getKeyName();
		
		List<Region> regionsSearch=serviceSearch.search_region(key_name);
		model.addAttribute("regionsS", regionsSearch);
		
		
		return "utilisateur/recherches/recherche_par_region";
	}
	
	@GetMapping("recherche_par_autorite_user")
	String recherche_par_autorite(Model model, @ModelAttribute("autorite") Search search) {
		String key_name=search.getKeyName();
		
		List<Autorite> autorites=serviceSearch.search_autorite(key_name);
		model.addAttribute("autorites", autorites);
		
		
		return "utilisateur/recherches/recherche_par_autorite";
	}
	
	@GetMapping("recherche_par_departement_user")
	String recherche_par_departement(Model model, @ModelAttribute("departement") Search search) {
		String key_name=search.getKeyName();
		
		List<Departement> departements=serviceSearch.search_departement(key_name);
		model.addAttribute("departements", departements);
		
		
		return "utilisateur/recherches/recherche_par_departement";
	}
	
	@GetMapping("recherche_faq_user")
	public String recherche_faq_admin(Model model) {
		Search search = new Search();
		model.addAttribute("search", search);
		return "utilisateur/recherches/add_data";
	}
	
	@PostMapping("find_all_data_faq_user")
	String get_data_recherche_by_region(Model model, @ModelAttribute("search") Search search) {
		String key_name=search.getKeyName();
		String key_type=search.getKeyType();
		
		if (key_type.equals("region")) {
			List<Region> regions=serviceSearch.search_region(key_name);
			model.addAttribute("regions", regions);
		}
		else if (key_type.equals("autorite")) {
			List<Autorite> autorites=serviceSearch.search_autorite(key_name);
			model.addAttribute("autorites", autorites);
		}
		else if (key_type.equals("departement")) {
			List<Departement> departements=serviceSearch.search_departement(key_name);
			model.addAttribute("departements", departements);
		}
		
		return "utilisateur/recherches/findAll_data";
	}

}
