import { Component } from '@angular/core';
import { Produit } from '../models/produit';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent {
  produit = new Produit();

  recupProduit(produitJson: any): void {
    console.debug('le produit avant recupération');
    console.debug(this.produit);
    this.produit = produitJson;
    console.debug('produit après récupération');
    console.debug(this.produit);
  }
}
