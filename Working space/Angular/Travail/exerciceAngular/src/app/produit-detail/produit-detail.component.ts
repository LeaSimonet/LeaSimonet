import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.css'],
})
export class ProduitDetailComponent implements OnInit {
  nomProduit!: string;

  constructor(private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    //this.nomProduit = this.activatedRoute.snapshot.params['id'];
    this.activatedRoute.params.subscribe(
      (params) => (this.nomProduit = params['id'])
    ); // Dès qu'il y a un observable, le seul endroit on pourra utiliser et on est sûrs qu'il y a un résultat c'est dans les parentèses du subsribe
    // L'abonnement reste actif jusqu'à ce qu'on se désabonne.
  }

  save() {
    //traitement sur ls données du formulaire
    //contrôle
    //vérifier que l'on a renseigné le nom etc...
    // Si tous les controle sont ok, on balancera une requete pour faie un create ou un update.
    // Un fois le traitmenent fini, on quitte la page et on est renvoyé ailleurs (liste des produits par exemple). Donc on doit être capable de quitter la page dans méthode timescript)
    this.router.navigateByUrl('/home');
  }
}
