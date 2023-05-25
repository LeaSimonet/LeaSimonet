import { Component, EventEmitter, Output } from '@angular/core';
import { Produit } from '../models/produit';

@Component({
  selector: 'app-form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css'],
})
export class FormProduitComponent {
  nom: string = '';
  prix: number = 0;

  @Output()
  produitVendu: EventEmitter<any> = new EventEmitter(); // je vais utiliser du json derrière avec any.

  envoyer() {
    this.produitVendu.emit({
      nom: this.nom,
      prix: this.prix,
    });
    this.nom = '';
    this.prix = 0;
  }
}
