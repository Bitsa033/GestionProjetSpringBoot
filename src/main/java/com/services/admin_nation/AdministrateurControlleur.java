package com.services.admin_nation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdministrateurControlleur {
	
	@Autowired
	private RegionService servicesRegions;
	@Autowired
	private DepartementService servicesDep;
	@Autowired
	private AutoriteService servicesAutorite;
	@Autowired
	private SearchService serviceSearch;
	AdministrationCamerounApplication adminCam= new AdministrationCamerounApplication();
	
	
	@GetMapping("findAll_data_regions_admin")
	String findAll_data_regions_admin(Model model) {
		
		List<Region> regions=servicesRegions.displayData();
		String nb_r=serviceSearch.nb_region();
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
			
			
			return "redirect:findAll_data_regions_admin";
		}
		
		Search search= new Search();
		model.addAttribute("regions", regions);
		model.addAttribute("region", search);
		model.addAttribute("nb", nb_r);
		
		return "administrateur/regions/findAll_data";
	}
	
	@GetMapping("print_data_regions_admin")
	String print_data_regions_admin(Model model) {
		
		List<Region> regions=servicesRegions.displayData();
		String nb_r=serviceSearch.nb_region();
		model.addAttribute("regions", regions);
		model.addAttribute("nb", nb_r);
		
		return "administrateur/regions/print_data";
	}
	
	@GetMapping("add_data_region_admin")
	public String  add_data_region_admin(Model model) {
		Region region= new Region();
		List<Autorite> auts=servicesAutorite.displayData();
		model.addAttribute("region", region);
		model.addAttribute("autorites", auts);
		return "administrateur/regions/add_data";
		
	}
	
	@GetMapping("find_data_region_admin")
	public String  find_data_region_admin(Model model) {
		Region region= new Region();
		model.addAttribute("region", region);
		return "administrateur/regions/find_data";
		
	}
	
	@PostMapping("edit_data_region_admin")
	public String  edit_data_region_admin(Model model,@ModelAttribute("region") Region region) {
		Optional<Region> r= servicesRegions.findDataById(region.getId());
		String r_id=r.get().getId();
		model.addAttribute("region", r);
		model.addAttribute("region_id", r_id);
		return "administrateur/regions/edit_data";
		
	}
	
	@PostMapping("save_data_region_admin")
	RedirectView save_data_region_admin(@ModelAttribute("region") Region region) throws IOException{
		
		String id=adminCam.genererID();
		Region r= new Region(id,region.getNomRegion(),region.getChefLieu(),region.getSuperficie(),region.getAutorite());
		servicesRegions.saveData(r);
		return new RedirectView("findAll_data_regions_admin");
	}
	
	@PostMapping("update_data_region_admin")
	public RedirectView update_data_region_admin(@ModelAttribute("region") Region region ) {
		String id=region.getId();
		String nom=region.getNomRegion();
		String superficie=region.getSuperficie();
		String autorite=region.getAutorite();
		String cheflieu=region.getChefLieu();
		servicesRegions.updateData(id,nom,superficie,autorite,cheflieu);
		
		return new RedirectView("findAll_data_regions_admin");
		
	}
	
	@GetMapping("delete_data_region_admin")
	public String  delete_data_region_admin(Model model) {
		Region region= new Region();
		model.addAttribute("region", region);
		return "administrateur/regions/delete_data";
		
	}
	
	@PostMapping("destroy_data_region_admin")
	public RedirectView destroy_data_region_admin(@ModelAttribute("region") Region region) {
		String r_id=region.getId();
		servicesRegions.deleteData(r_id);
		return new RedirectView("findAll_data_regions_admin");
		
	}
	
	// Méthodes pour l'entité Depament
	
	@GetMapping("findAll_data_departements_admin")
	String findAll_data_autorites(Model model) {
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
			
			return "redirect:findAll_data_departements_admin";
		}
		String nb_d= serviceSearch.nb_departements();
		model.addAttribute("departements", departements);
		Search search=new Search();
		model.addAttribute("departement", search);
		model.addAttribute("nb", nb_d);
		return "administrateur/departements/findAll_data";
	}
	
	@GetMapping("print_data_departements_admin")
	String print_data_departements_admin(Model model) {
		List<Departement> autorites=servicesDep.displayData();
		String nb_d= serviceSearch.nb_departements();
		model.addAttribute("departements", autorites);
		model.addAttribute("nb", nb_d);
		return "administrateur/departements/print_data";
	}
	
	
	@GetMapping("add_data_departement_admin")
	public String  add_data(Model model) {
		Departement autorite= new Departement();
		model.addAttribute("departement", autorite);
		List<Autorite> auts=servicesAutorite.displayData();
		List<Region> regions=servicesRegions.displayData();
		model.addAttribute("autorites", auts);
		model.addAttribute("regions", regions);
		return "administrateur/departements/add_data";
		
	}
	
	@GetMapping("find_data_departement_admin")
	public String  find_data_departement(Model model) {
		Departement departement= new Departement();
		model.addAttribute("departement", departement);
		return "administrateur/departements/find_data";
		
	}
	
	@PostMapping("edit_data_departement_admin")
	public String  edit_data_departement(Model model,@ModelAttribute("departement") Departement dep) {
		Optional<Departement> r= servicesDep.findDataById(dep.getId());
		String r_id=r.get().getId();
		model.addAttribute("departement", r);
		model.addAttribute("departement_id", r_id);
		return "administrateur/departements/edit_data";
		
	}
	
	@PostMapping("save_data_departement_admin")
	RedirectView save_data_departement(@ModelAttribute("departement") Departement depar) throws IOException{
		
		String id=adminCam.genererID();
		Departement r= new Departement(id,depar.getNomDep(),depar.getChefLieu(),depar.getSuperficie(),depar.getAutorite(),depar.getRegion());
		servicesDep.saveData(r);
		return new RedirectView("findAll_data_departements_admin");
	}
	
	@PostMapping("update_data_departement_admin")
	public RedirectView update_data(@ModelAttribute("departement") Departement dep ) {
		
		String id=dep.getId();
		String nom=dep.getNomDep();
		String superficie=dep.getSuperficie();
		String autorite=dep.getAutorite();
		String cheflieu=dep.getChefLieu();
		servicesDep.updateData(id,nom,superficie,autorite,cheflieu);
		
		return new RedirectView("findAll_data_departements_admin");
		
	}
	
	@GetMapping("delete_data_departement_admin")
	public String  delete_data(Model model) {
		Departement autorite= new Departement();
		model.addAttribute("departement", autorite);
		return "administrateur/departements/delete_data";
		
	}
	
	@PostMapping("destroy_data_departement_admin")
	public RedirectView delete_data_action(@ModelAttribute("departement") Departement autorite) {
		String r_id=autorite.getId();
		servicesDep.deleteData(r_id);
		return new RedirectView("findAll_data_departements_admin");
		
	}
	
	// Méthodes pour l'entité Autorite
	
	@GetMapping("findAll_data_autorites_admin")
	String findAll_data_autorites_admin(Model model) {
		Search search= new Search();
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
			
			
			return "redirect:findAll_data_autorites_admin";
		}
		String nb_d= serviceSearch.nb_autorites();
		model.addAttribute("autorites", autorites);
		model.addAttribute("autorite", search);
		model.addAttribute("nb", nb_d);
		return "administrateur/autorites/findAll_data";
	}
	
	@GetMapping("print_data_autorites_admin")
	String print_data_autorites_admin(Model model) {
		List<Autorite> autorites=servicesAutorite.displayData();
		String nb_d= serviceSearch.nb_autorites();
		model.addAttribute("autorites", autorites);
		model.addAttribute("nb", nb_d);
		return "administrateur/autorites/print_data";
	}
	
	
	@GetMapping("add_data_autorite_admin")
	public String  add_data_autorite_admin(Model model) {
		Autorite autorite= new Autorite();
		model.addAttribute("autorite", autorite);
		return "administrateur/autorites/add_data";
		
	}
	
	@GetMapping("find_data_autorite_admin")
	public String  find_data_autorite_admin(Model model) {
		Autorite autorite= new Autorite();
		model.addAttribute("autorite", autorite);
		return "administrateur/autorites/find_data";
		
	}
	
	@PostMapping("edit_data_autorite_admin")
	public String  edit_data_autorite_admin(Model model,@ModelAttribute("autorite") Autorite autorite) {
		Optional<Autorite> r= servicesAutorite.findDataById(autorite.getId());
		String r_id=r.get().getId();
		model.addAttribute("autorite", r);
		model.addAttribute("autorite_id", r_id);
		return "administrateur/autorites/edit_data";
		
	}
	
	@PostMapping("save_data_autorite_admin")
	RedirectView save_data_autorite(@ModelAttribute("autorite") Autorite autorite) throws IOException{
		
		String id=adminCam.genererID();
		Autorite r= new Autorite(id,autorite.getNom(),autorite.getType());
		servicesAutorite.saveData(r);
		return new RedirectView("findAll_data_autorites_admin");
	}
	
	@PostMapping("update_data_autorite_admin")
	public RedirectView update_data(@ModelAttribute("autorite") Autorite autorite ) {
		
		String id=autorite.getId();
		String nom=autorite.getNom();
		String fonction=autorite.getType();
		servicesAutorite.updateData(id,nom,fonction);
		
		return new RedirectView("findAll_data_autorites_admin");
		
	}
	
	@GetMapping("delete_data_autorite_admin")
	public String  delete_data_autorite_admin(Model model) {
		Autorite autorite= new Autorite();
		model.addAttribute("autorite", autorite);
		return "administrateur/autorites/delete_data";
		
	}
	
	@PostMapping("destroy_data_autorite_admin")
	public RedirectView destroy_data_autorite_admin(@ModelAttribute("autorite") Autorite autorite) {
		String r_id=autorite.getId();
		servicesAutorite.deleteData(r_id);
		return new RedirectView("findAll_data_autorites_admin");
		
	}
	
	// Méthodes pour les recherches
	
	@GetMapping("recherche_par_region_admin")
	String recherche_par_region(Model model, @ModelAttribute("region") Search search) {
		String key_name=search.getKeyName();
		
		List<Region> regionsSearch=serviceSearch.search_region(key_name);
		model.addAttribute("regionsS", regionsSearch);
		
		
		return "administrateur/recherches/recherche_par_region";
	}
	
	@GetMapping("recherche_par_autorite_admin")
	String recherche_par_autorite(Model model, @ModelAttribute("autorite") Search search) {
		String key_name=search.getKeyName();
		
		List<Autorite> autorites=serviceSearch.search_autorite(key_name);
		model.addAttribute("autorites", autorites);
		
		
		return "administrateur/recherches/recherche_par_autorite";
	}
	
	@GetMapping("recherche_par_departement_admin")
	String recherche_par_departement(Model model, @ModelAttribute("departement") Search search) {
		String key_name=search.getKeyName();
		
		List<Departement> departements=serviceSearch.search_departement(key_name);
		model.addAttribute("departements", departements);
		
		
		return "administrateur/recherches/recherche_par_departement";
	}
	
	@GetMapping("recherche_faq_admin")
	public String recherche_faq_admin(Model model) {
		Search search = new Search();
		model.addAttribute("search", search);
		return "administrateur/recherches/add_data";
	}
	
	@GetMapping("find_all_data_faq_admin")
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
		
		return "administrateur/recherches/findAll_data";
	}
	

}
