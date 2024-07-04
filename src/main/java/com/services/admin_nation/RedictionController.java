package com.services.admin_nation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RedictionController {
	
	@GetMapping("page_region")
	public String page_home(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:findAll_data_regions_admin";
		}
		
		return "redirect:findAll_data_regions_user";
	}
	
	@GetMapping("page_add_region")
	public String page_add_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:add_data_region_admin";
		}
		
		return "redirect:findAll_data_regions_user";
	}
	
	@GetMapping("page_get_region")
	public String page_get_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:find_data_region_admin";
		}
		
		return "redirect:findAll_data_regions_user";
	}
	
	@GetMapping("page_edit_region")
	public String page_edit_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:find_data_region_admin";
		}
		
		return "redirect:findAll_data_regions_user";
	}
	
	@GetMapping("page_delete_region")
	public String page_delete_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:delete_data_region_admin";
		}
		
		return "redirect:findAll_data_regions_user";
	}
	
	@PostMapping("page_save_region")
	public String page_save_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:save_data_region_admin";
		}
		
		return "redirect:findAll_data_regions_user";
	}
	
	@PostMapping("page_update_region")
	public String page_update_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:update_data_region_admin";
		}
		
		return "redirect:findAll_data_regions_user";
	}
	
	@PostMapping("page_destroy_region")
	public String page_destroy_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:destroy_data_region_admin";
		}
		
		return "redirect:findAll_data_regions_user";
	}
	
	
	
	@GetMapping("page_autorite")
	public String page_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:findAll_data_autorites_admin";
		}
		
		return "redirect:findAll_data_autorites_user";
	}
	
	@GetMapping("page_add_autorite")
	public String page_add_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:add_data_autorite_admin";
		}
		
		return "redirect:findAll_data_autorites_user";
	}
	
	@GetMapping("page_get_autorite")
	public String page_get_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:find_data_autorite_admin";
		}
		
		return "redirect:findAll_data_autorites_user";
	}
	
	@GetMapping("page_edit_autorite")
	public String page_edit_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:find_data_autorite_admin";
		}
		
		return "redirect:findAll_data_autorites_user";
	}
	
	@GetMapping("page_delete_autorite")
	public String page_delete_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:delete_data_autorite_admin";
		}
		
		return "redirect:findAll_data_autorites_user";
	}
	
	@PostMapping("page_save_autorite")
	public String page_save_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:save_data_autorite_admin";
		}
		
		return "redirect:findAll_data_autorites_user";
	}
	
	@PostMapping("page_update_autorite")
	public String page_update_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:update_data_autorite_admin";
		}
		
		return "redirect:findAll_data_autorites_user";
	}
	
	@PostMapping("page_destroy_autorite")
	public String page_destroy_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:destroy_data_autorite_admin";
		}
		
		return "redirect:findAll_data_autorites_user";
	}
	
	@GetMapping("page_departement")
	public String page_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:findAll_data_departements_admin";
		}
		
		return "redirect:findAll_data_departements_user";
	}
	
	@GetMapping("page_add_departement")
	public String page_add_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:add_data_departement_admin";
		}
		
		return "redirect:findAll_data_departements_user";
	}
	
	@GetMapping("page_get_departement")
	public String page_get_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:find_data_departement_admin";
		}
		
		return "redirect:findAll_data_departements_user";
	}
	
	@GetMapping("page_edit_departement")
	public String page_edit_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:edit_data_departement_admin";
		}
		
		return "redirect:findAll_data_departements_user";
	}
	
	@GetMapping("page_delete_departement")
	public String page_delete_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:delete_data_departement_admin";
		}
		
		return "redirect:findAll_data_departements_user";
	}
	
	@PostMapping("page_save_departement")
	public String page_save_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:save_data_departement_admin";
		}
		
		return "redirect:findAll_data_departements_user";
	}
	
	@PostMapping("page_update_departement")
	public String page_update_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:update_data_departement_admin";
		}
		
		return "redirect:findAll_data_departements_user";
	}
	
	@PostMapping("page_destroy_departement")
	public String page_destroy_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:destroy_data_departement_admin";
		}
		
		return "redirect:findAll_data_departements_user";
	}
	
	@GetMapping("page_recherche_par_region")
	public String page_recherche(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:recherche_par_region_admin";
		}
		
		return "redirect:recherche_par_region_user";
	}
	
	@GetMapping("page_recherche_par_autorite")
	public String page_recherche_par_autorite(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:recherche_par_autorite_admin";
		}
		
		return "redirect:recherche_par_autorite_user";
	}
	
	@GetMapping("page_recherche_par_departement")
	public String page_recherche_par_departement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:recherche_par_departement_admin";
		}
		
		return "redirect:recherche_par_departement_user";
	}
	
	@GetMapping("page_recherche_par_arrondissement")
	public String page_recherche_par_arrondissement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:recherche_par_arrondissement_admin";
		}
		
		return "redirect:recherche_par_arrondissement_user";
	}
	
	@GetMapping("page_arrondissement")
	public String page_arrondissement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:findAll_data_arrondissements_admin";
		}
		
		return "redirect:findAll_data_arrondissements_user";
	}
	
	@GetMapping("page_add_arrondissement")
	public String page_add_arrondissement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:add_data_arrondissement_admin";
		}
		
		return "redirect:findAll_data_arrondissements_user";
	}
	
	@GetMapping("page_get_arrondissement")
	public String page_get_arrondissement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:find_data_arrondissement_admin";
		}
		
		return "redirect:findAll_data_arrondissements_user";
	}
	
	@GetMapping("page_edit_arrondissement")
	public String page_edit_arrondissement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:find_data_arrondissement_admin";
		}
		
		return "redirect:findAll_data_arrondissements_user";
	}
	
	@GetMapping("page_delete_arrondissement")
	public String page_delete_arrondissement(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:delete_data_arrondissement_admin";
		}
		
		return "redirect:findAll_data_arrondissements_user";
	}
	

}
