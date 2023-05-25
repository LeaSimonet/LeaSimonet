package soprasteria.formation.eshop.restcontrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.entities.Commande;
import soprasteria.formation.eshop.entities.Produit;
import soprasteria.formation.eshop.model.ElementPanier;
import soprasteria.formation.eshop.services.ClientService;
import soprasteria.formation.eshop.services.CommandeService;
import soprasteria.formation.eshop.services.ProduitService;

@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeSrv;
	@Autowired
	private ClientService clientSrv;
	@Autowired
	private ProduitService produitSrv;

	@PostMapping("/{idClient}")
	public Commande create(@PathVariable("idClient") Long idClient, @RequestBody List<ElementPanier> elements) {
		Client client = clientSrv.getById(idClient);

		Map<Produit, Integer> panier = new HashMap<>();
		; // parcourir la liste elements
		elements.forEach(e -> {
			panier.put(produitSrv.getById(e.getIdProduit()), e.getQuantite());

		});
		// pour chaque element produitSrv.getById(idProduit)
		// put dans une Map<Produit,Integer>
		return commandeSrv.create(client, panier);

	}
}
