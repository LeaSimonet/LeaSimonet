import { Component } from '@angular/core';
import { Produit } from '../models/produit';

@Component({
  selector: 'app-demo-directive',
  templateUrl: './demo-directive.component.html',
  styleUrls: ['./demo-directive.component.css'],
})
export class DemoDirectiveComponent {
  //tabString:Array<string>=[]
  //tabString: string[]=[]

  tabString = [
    'element 1',
    'element 2',
    'element 3',
    'element 4',
    'element 5',
    'element 6',
  ];

  tabProduit = [
    new Produit('ordi', 1000),
    new Produit('pantalon', 2000),
    new Produit('meuble', 3000),
    new Produit('téléphone', 4000),
    new Produit('clavier', 5000),
    new Produit('écouteurs', 6000),
  ];

  constructor() {
    this.tabProduit.push(new Produit('souris', 100000));
  }

  display() {
    return true;
  }
}
