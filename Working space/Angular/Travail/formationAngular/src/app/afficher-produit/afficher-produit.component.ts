import { Component, Input, OnInit } from '@angular/core';
import { Produit } from '../models/produit';

@Component({
  selector: 'app-afficher-produit',
  templateUrl: './afficher-produit.component.html',
  styleUrls: ['./afficher-produit.component.css'],
})
export class AfficherProduitComponent implements OnInit {
  @Input()
  produit!: Produit;

  constructor() {
    this.initProduit();
  }

  ngOnInit(): void {}

  initProduit() {
    this.produit = new Produit('Télévision', 900);
  }
}
