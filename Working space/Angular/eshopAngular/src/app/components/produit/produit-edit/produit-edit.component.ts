import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Fournisseur } from 'src/app/model/fournisseur';
import { Produit } from 'src/app/model/produit';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produit-edit',
  templateUrl: './produit-edit.component.html',
  styleUrls: ['./produit-edit.component.css'],
})
export class ProduitEditComponent implements OnInit {
  produit!: Produit;
  fournisseurs: Fournisseur[] = [];

  constructor(
    private produitSrv: ProduitService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    let fournisseur: Fournisseur = new Fournisseur();
    this.produit = new Produit();
    this.produit.fournisseur = fournisseur;
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.produitSrv.getById(params['id']).subscribe((res) => {
          this.produit = res;
        });
      }
    });

    this.produitSrv.getFournisseurs().subscribe((fournisseurs) => {
      this.fournisseurs = fournisseurs;
    });
  }

  save() {
    if (this.produit.id) {
      this.produitSrv.update(this.produit).subscribe((res) => {
        this.router.navigateByUrl('/produit');
      });
    } else {
      this.produitSrv.create(this.produit).subscribe((res) => {
        this.router.navigateByUrl('/produit');
      });
    }
  }

  compareFn(fournisseur1: Fournisseur, fournisseur2: Fournisseur): boolean {
    return fournisseur1 && fournisseur2
      ? fournisseur1.id === fournisseur2.id
      : fournisseur1 === fournisseur2;
  }
}
