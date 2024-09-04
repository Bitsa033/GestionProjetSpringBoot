package com.services.gestion_projets;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class GestionProjetController {
	
	@Autowired
	private ProjetService projetService;
	@Autowired
	private EquipeProjetService equipeService;
	@Autowired
	private TacheService tacheService;
	@Autowired
	private TacheMembreService tacheMService;
	@Autowired
	private UsersService userss;
	
	@GetMapping("print_user")
	String print_user(Model model) {
		List<User> users = userss.displayData();
		model.addAttribute("users", users);
		model.addAttribute("nb", userss.nb_data());
		return "utilisateur/print";
	}
	@GetMapping("find_all_user")
	String user(Model model) {
		List<User> users = userss.displayData();
		model.addAttribute("users", users);
		model.addAttribute("nb", userss.nb_data());
		return "utilisateur/find_all";
	}
	@GetMapping("find_all_projet")
	String projet(Model model) {
		List<Projet> projets = projetService.displayData();
		model.addAttribute("projets", projets);
		model.addAttribute("nb", projetService.nb_data());
		return "projet/find_all";
	}
	@GetMapping("find_all_equipe")
	String equipe(Model model) {
		List<EquipeProjet> equipe = equipeService.displayData();
		model.addAttribute("equipe", equipe);
		model.addAttribute("nb", equipeService.nb_data());
		return "equipeProjet/find_all";
	}
	@GetMapping("find_all_tache")
	String tache(Model model) {
		List<Tache> tache = tacheService.displayData();
		model.addAttribute("taches", tache);
		model.addAttribute("nb", tacheService.nb_data());
		return "tache/find_all";
	}
	@GetMapping("find_all_tache_membre")
	String tache_membre(Model model) {
		List<TacheMembre> taches_membres = tacheMService.displayData();
		model.addAttribute("taches_membres", taches_membres);
		model.addAttribute("nb", tacheMService.nb_data());
		return "tacheMembreEquipe/find_all";
	}
	@GetMapping("add_user")
	String add_user(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "utilisateur/add";
	}
	@GetMapping("add_projet")
	String add(Model model) {
		Projet projet = new Projet();
		List<User> users = userss.displayData();
		model.addAttribute("users", users);
		model.addAttribute("projet", projet);
		return "projet/add";
	}
	@GetMapping("add_equipe")
	String add_equipe(Model model) {
		EquipeProjet equipe = new EquipeProjet();
		List<User> users = userss.displayData();
		List<Projet> projets = projetService.displayData();
		model.addAttribute("users", users);
		model.addAttribute("equipe", equipe);
		model.addAttribute("projets", projets);
		return "equipeProjet/add";
	}
	@GetMapping("add_tache")
	String add_tache(Model model) {
		Tache tache = new Tache();
		List<Projet> projets = projetService.displayData();
		model.addAttribute("projets", projets);
		model.addAttribute("tache", tache);
		return "tache/add";
	}
	@GetMapping("add_tache_membre")
	String add_tache_membre(Model model) {
		TacheMembre tacheM = new TacheMembre();
		List<User> users = userss.displayData();
		List<Tache> taches = tacheService.displayData();
		model.addAttribute("users", users);
		model.addAttribute("taches", taches);
		model.addAttribute("tacheM", tacheM);
		return "tacheMembreEquipe/add";
	}
	@GetMapping("find_user")
	String find_user(Model model) {
		User user= new User();
		model.addAttribute("user", user);
		return "utilisateur/find";
	}
	@GetMapping("find_projet")
	String find(Model model) {
		Projet projet= new Projet();
		model.addAttribute("projet", projet);
		return "projet/find";
	}
	@GetMapping("find_equipe")
	String find_equipe(Model model) {
		EquipeProjet equipe= new EquipeProjet();
		model.addAttribute("equipe", equipe);
		
		return "equipeProjet/find";
	}
	@GetMapping("find_tache")
	String find_tache(Model model) {
		Tache tache= new Tache();
		model.addAttribute("tache", tache);
		
		return "tache/find";
	}
	@GetMapping("find_tache_membre")
	String find_tache_membre(Model model) {
		TacheMembre tacheM= new TacheMembre();
		model.addAttribute("tacheM", tacheM);
		
		return "tacheMembreEquipe/find";
	}
	@PostMapping("edit_user")
	String edit_user(Model model,@ModelAttribute("user") User user) {
		String i=String.valueOf(user.getId());
		Optional<User> u= userss.findData(i);
		model.addAttribute("user", u);
		model.addAttribute("id", u.get().getId());
		return "utilisateur/edit";
	}
	@PostMapping("edit_projet")
	String edit(Model model,@ModelAttribute("projet") Projet projet) {
		List<User> users = userss.displayData();
		model.addAttribute("users", users);
		String i=String.valueOf(projet.getId());
		Optional<Projet> p= projetService.findData(i);
		model.addAttribute("projet", p);
		model.addAttribute("id", p.get().getId());
		return "projet/edit";
	}
	@PostMapping("edit_equipe")
	String edit_equipe(Model model,@ModelAttribute("equipe") EquipeProjet equipe) {
		List<User> users = userss.displayData();
		model.addAttribute("users", users);
		String i=String.valueOf(equipe.getId());
		Optional<EquipeProjet> p= equipeService.findData(i);
		model.addAttribute("equipe", p);
		model.addAttribute("id", p.get().getId());
		return "equipeProjet/edit";
	}
	@PostMapping("edit_tache")
	String edit_tache(Model model,@ModelAttribute("tache") Tache tache) {
		List<Projet> projets = projetService.displayData();
		model.addAttribute("projets", projets);
		String i=String.valueOf(tache.getId());
		Optional<Tache> t= tacheService.findData(i);
		model.addAttribute("tache", t);
		model.addAttribute("id", t.get().getId());
		return "tache/edit";
	}
	@PostMapping("edit_tache_membre")
	String edit_tache_membre(Model model,@ModelAttribute("tacheM") TacheMembre tache) {
		List<User> users = userss.displayData();
		List<Tache> taches = tacheService.displayData();
		model.addAttribute("users", users);
		model.addAttribute("taches", taches);
		String i=String.valueOf(tache.getId());
		Optional<TacheMembre> t= tacheMService.findData(i);
		model.addAttribute("tacheM", t);
		model.addAttribute("id", t.get().getId());
		return "tacheMembreEquipe/edit";
	}
	@PostMapping("save_projet")
	String save(@ModelAttribute("projet") Projet p) {
		projetService.saveData(p);
		return "redirect:add_projet";
	}
	@PostMapping("save_user")
	String save(@ModelAttribute("user") User user) {
		userss.saveData(user);
		return "redirect:add_user";
	}
	@PostMapping("save_equipe")
	String save_equipe(@ModelAttribute("equipe") EquipeProjet equipe) {
		equipeService.saveData(equipe);
		return "redirect:add_equipe";
	}
	@PostMapping("save_tache")
	String save_tache(@ModelAttribute("tache") Tache tache) {
		tacheService.saveData(tache);
		return "redirect:add_tache";
	}
	@PostMapping("save_tache_membre")
	String save_tache_membre(@ModelAttribute("tacheM") TacheMembre tacheM) {
		tacheMService.saveData(tacheM);
		return "redirect:add_tache_membre";
	}
	@PostMapping("update_projet")
	String update(@ModelAttribute("projet") Projet p) {
		String i=String.valueOf(p.getId());
		projetService.updateData(i,p);
		return "redirect:find_all_projet";
	}
	@PostMapping("update_user")
	String update_user(@ModelAttribute("user") User user) {
		String i=String.valueOf(user.getId());
		userss.updateData(i,user);
		return "redirect:find_all_user";
	}
	@PostMapping("update_equipe")
	String update_equipe(@ModelAttribute("equipe") EquipeProjet equipe) {
		String i=String.valueOf(equipe.getId());
		equipeService.updateData(i,equipe);
		return "redirect:find_all_equipe";
	}
	@PostMapping("update_tache")
	String update_tache(@ModelAttribute("tache") Tache tache) {
		String i=String.valueOf(tache.getId());
		tacheService.updateData(i,tache);
		return "redirect:find_all_tache";
	}
	@PostMapping("update_tache_membre")
	String update_tache_membre(@ModelAttribute("tacheM") TacheMembre tacheM) {
		String i=String.valueOf(tacheM.getId());
		tacheMService.updateData(i,tacheM);
		return "redirect:find_all_tache_membre";
	}
	@GetMapping("delete_user")
	public String  delete_user(Model model) {
		User user= new User();
		model.addAttribute("user", user);
		return "utilisateur/delete";
	}
	@GetMapping("delete_projet")
	public String  delete(Model model) {
		Projet projet= new Projet();
		model.addAttribute("projet", projet);
		return "projet/delete";
	}
	@GetMapping("delete_equipe")
	public String  delete_equipe(Model model) {
		EquipeProjet equipe= new EquipeProjet();
		model.addAttribute("equipe", equipe);
		return "equipeProjet/delete";
	}
	@GetMapping("delete_tache")
	public String  delete_tache(Model model) {
		Tache tache= new Tache();
		model.addAttribute("tache", tache);
		return "tache/delete";
	}
	@GetMapping("delete_tache_membre")
	public String  delete_tache_membre(Model model) {
		TacheMembre tacheM= new TacheMembre();
		model.addAttribute("tacheM", tacheM);
		return "tacheMembreEquipe/delete";
	}
	
	@PostMapping("destroy_user")
	public RedirectView destroy_user(@ModelAttribute("user") User user) {
		String i=String.valueOf(user.getId());
		userss.deleteData(i);
		return new RedirectView("find_all_user");
		
	}
	@PostMapping("destroy_projet")
	public RedirectView destroy(@ModelAttribute("projet") Projet projet) {
		String i=String.valueOf(projet.getId());
		projetService.deleteData(i);
		return new RedirectView("find_all_projet");
		
	}
	@PostMapping("destroy_equipe")
	public RedirectView destroy_equipe(@ModelAttribute("equipe") EquipeProjet equipe) {
		String i=String.valueOf(equipe.getId());
		equipeService.deleteData(i);
		return new RedirectView("find_all_equipe");
		
	}
	@PostMapping("destroy_tache")
	public RedirectView destroy_tache(@ModelAttribute("tache") Tache tache) {
		String i=String.valueOf(tache.getId());
		tacheService.deleteData(i);
		return new RedirectView("find_all_tache");	
	}
	@PostMapping("destroy_tache_membre")
	public RedirectView destroy_tache_membre(@ModelAttribute("tacheM") TacheMembre tacheM) {
		String i=String.valueOf(tacheM.getId());
		tacheMService.deleteData(i);
		return new RedirectView("find_all_tache_membre");
		
	}

}
