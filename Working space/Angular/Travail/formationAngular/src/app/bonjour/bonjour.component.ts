import { Personne } from './../models/personne';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  // @Input()
  // prenom!: string;
  // @Input()
  // nom!: string;
  // @Input('photo')
  // picture!: string;

  @Input()
  personne!: Personne; // ! : promet au code que ce truc sera utiliser quelque part. Par contre aucun control sera fait donc bien s'assurer de le faire sinon crash.

  constructor() {
    this.initPersonne();
  }

  ngOnInit(): void {
    //   //garantit le traitement des inputs
    //   //this.personne = new Personne(this.prenom, this.nom, this.picture);
  }

  initPersonne() {
    this.personne = new Personne(
      'Genshin',
      'Impact',
      'https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.ecobalade.fr%2Fespece%2Fchouette-hulotte&psig=AOvVaw3IbQQUYGtCiUUESLrzqRAg&ust=1685021369431000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCMiGuPOHjv8CFQAAAAAdAAAAABAE'
    );
  }
}
