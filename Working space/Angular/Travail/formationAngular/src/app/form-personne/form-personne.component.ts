import { Component, EventEmitter, Output } from '@angular/core';
import { Personne } from '../models/personne';

@Component({
  selector: 'app-form-personne',
  templateUrl: './form-personne.component.html',
  styleUrls: ['./form-personne.component.css'],
})
export class FormPersonneComponent {
  personne = new Personne();

  @Output()
  personnePrete: EventEmitter<Personne> = new EventEmitter(); //definition de l'évenement à traiter pour récupérer la donnée. Ne déclnche pas l'event mais dit juste que ce component declenchera un component de ce type

  envoyer() {
    //declenchement
    this.personnePrete.emit(this.personne);
    this.personne = new Personne();
  }
}
