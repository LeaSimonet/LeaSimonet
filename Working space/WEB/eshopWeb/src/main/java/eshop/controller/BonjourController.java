package eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Personne;

@Controller
@RequestMapping("/bonjour")
public class BonjourController {

	@GetMapping("")
	public String bonjour() {
		return "bonjour/formBonjour";
	}
	
	
	@PostMapping("")
//	public String traitementFormulaire(@RequestParam(name="prenom")String prenom, @RequestParam(name="nom")String nom, Model model) {
//		Personne personne=new Personne();
//		personne.setNom(nom);
//		personne.setPrenom(prenom);
//		model.addAttribute("personne", personne);
//		if(prenom.isEmpty()|| nom.isEmpty()) {
//			model.addAttribute("erreur", true);
//			return "bonjour/formBonjour";
//		}
//		
//		return "bonjour/bonjour";
//	}
	
	public String traitementFormulaire(@ModelAttribute Personne personne, Model model) {
		model.addAttribute("personne", personne);
		if(personne.getPrenom().isEmpty()|| personne.getNom().isEmpty()) {
			model.addAttribute("erreur", true);
			return "bonjour/formBonjour";
		}
		
		return "bonjour/bonjour";
	}
	
}
