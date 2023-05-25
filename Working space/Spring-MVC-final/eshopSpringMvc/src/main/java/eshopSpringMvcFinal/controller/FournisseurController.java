package eshopSpringMvcFinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.entities.Fournisseur;
import eshop.services.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired 
	private FournisseurService fournisseurSrv;
	
	
	@GetMapping({"", "/list"}) // la méthode sera appelée à l'aide d l'une de ces url
	public String list(Model model) {  // La méthode elle-même accepte un objet Model en tant que paramètre, qui est fourni par le framework Spring pour permettre au contrôleur de transmettre des données à la vue.
		model.addAttribute("fournisseurs", fournisseurSrv.getAll()); // Dans ce cas, la méthode ajoute un attribut nommé "fournisseurs" 
		// à l'objet Model en utilisant la méthode addAttribute() et en passant la liste de tous les fournisseurs récupérée par la méthode getAll() 
		// de l'objet fournisseurSrv (qui doit être un service Spring gérant la récupération de données pour les fournisseurs).
		return "fournisseur/list";
		// Enfin, la méthode renvoie une chaîne de caractères "fournisseur/list", 
		// qui est le nom de la vue JSP à afficher. Cette chaîne sera résolue par un ViewResolver (tel que celui configuré dans la classe WebConfig mentionnée précédemment) 
		// pour renvoyer la vue JSP correspondante à l'utilisateur.
		
		
		// En somme, cette méthode est chargée de récupérer la liste de tous les fournisseurs 
		// à partir d'un service Spring, de l'ajouter à l'objet Model, et de 
		// renvoyer le nom de la vue JSP qui doit être affichée pour afficher cette liste.
		
	}
	
	
	@GetMapping("/delete") // La méthode elle-même accepte deux paramètres :
	public String delete(@RequestParam(name="id") Long id, Model model) { // Un paramètre id annoté avec @RequestParam, qui indique que la valeur pour ce paramètre doit être extraite de la requête HTTP en tant que paramètre nommé "id".
		// Un objet Model en tant que paramètre, qui est fourni par le framework Spring pour permettre au contrôleur de transmettre des données à la vue.
		fournisseurSrv.delete(id);
		model.addAttribute("delete", id);
		return "redirect:/fournisseur/list";
		
		
		// En somme, cette méthode est chargée de supprimer 
		// un fournisseur à partir de son ID, d'ajouter l'ID du fournisseur supprimé à 
		// l'objet Model, et de rediriger l'utilisateur vers la liste des fournisseurs mise à jour après la suppression.
	}
	
	
	private String goForm (Fournisseur fournisseur, Model model) {
		model.addAttribute("fournisseur", fournisseur); 
		return "fournisseur/edit";
		
		//En somme, cette méthode est utilisée pour pré-remplir un formulaire de modification avec 
		// les données d'un fournisseur et renvoyer la vue correspondante. 
	}
	
	
	@GetMapping("/edit")
	public  String update(@RequestParam("id") Long id, Model model ) {
		return goForm(fournisseurSrv.getById(id), model);
		
	}
	
	@GetMapping("/add")
	public String add( Model model) {
		return goForm(new Fournisseur(), model);
	}
	
	
	@PostMapping("/save")
	//La méthode elle-même accepte trois paramètres :
//Un objet Fournisseur annoté avec @ModelAttribute, qui est lié aux champs du formulaire soumis et contient les données du fournisseur à enregistrer.
//Un objet BindingResult, qui est fourni par Spring pour valider les données du formulaire et stocker les erreurs de validation éventuelles.
// Un objet Model en tant que paramètre, qui est fourni par le framework Spring pour permettre au contrôleur de transmettre des données à la vue.
	public String save (@Valid @ModelAttribute Fournisseur fournisseur, BindingResult br, Model model) {
		
		//La méthode commence par valider les données du formulaire en vérifiant si BindingResult 
		// contient des erreurs avec la méthode hasErrors(). Si des erreurs sont détectées, la méthode renvoie 
		// à nouveau vers la vue d'édition du formulaire avec les données soumises initiales pour afficher les erreurs détectées.
		if(br.hasErrors()) {
			return goForm(fournisseur, model);
		}
		
		// Si les données sont valides, la méthode vérifie si l'ID du fournisseur est null. 
		// Si c'est le cas, cela signifie qu'un nouveau fournisseur doit être créé, donc la méthode appelle la 
		// méthode create() de l'objet fournisseurSrv pour créer le fournisseur et stocke l'ID du fournisseur nouvellement créé dans l'objet Model.
		if(fournisseur.getId()==null) {
			fournisseur=fournisseurSrv.create(fournisseur);
			model.addAttribute("create", fournisseur.getId());
		}
		// Si l'ID du fournisseur n'est pas null, cela signifie qu'un fournisseur existant doit être mis à jour. 
		// Dans ce cas, la méthode appelle la méthode update() de l'objet fournisseurSrv pour mettre à jour 
		// le fournisseur et stocke l'ID du fournisseur mis à jour dans l'objet Model.
		
		else {
			fournisseur=fournisseurSrv.update(fournisseur);
			model.addAttribute("update", fournisseur.getId());
		}
		return "redirect:/fournisseur/list";
	
	// En somme, cette méthode est utilisée pour enregistrer les données soumises 
		// d'un formulaire de création ou de modification de fournisseur, et rediriger l'utilisateur vers la liste des fournisseurs mise à jour.
	
	}
	
	
}
