import { Component } from '@angular/core';
import { Personne } from '../models/personne';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css'],
})
export class PersonneComponent {
  prenom = '';
  nom = '';
  personne = new Personne();
  personneAEnvoyer = new Personne();
  tabPersonne: Personne[] = [];

  recupPersonne(personne: Personne) {
    this.personneAEnvoyer = new Personne();
  }
}
