import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/model/produit';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.css'],
})
export class ProduitListComponent implements OnInit {
  produits!: Produit[];

  constructor(private produitSrv: ProduitService) {}

  ngOnInit(): void {
    this.listProduits();
  }

  listProduits() {
    this.produitSrv.getProduits().subscribe((resultat) => {
      this.produits = resultat;
    });
  }

  deleteProduit(id: number) {
    this.produitSrv.deleteById(id).subscribe(() => {
      this.listProduits();
    });
  }
}
