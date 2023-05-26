import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../model/produit';
import { Fournisseur } from '../model/fournisseur';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  constructor(private httpClient: HttpClient) {}

  public getProduits(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(
      'http://localhost:8080/eshop/api/produit'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/eshop/api/produit/${id}`
    );
  }

  public create(produit: Produit): Observable<Produit> {
    return this.httpClient.post<Produit>(
      `http://localhost:8080/eshop/api/produit`,
      produit
    );
  }

  public update(produit: Produit): Observable<Produit> {
    return this.httpClient.put<Produit>(
      `http://localhost:8080/eshop/api/produit/${produit.id}`,
      produit
    );
  }

  public getById(id: number): Observable<Produit> {
    return this.httpClient.get<Produit>(
      `http://localhost:8080/eshop/api/produit/${id}`
    );
  }

  public getFournisseurs(): Observable<Fournisseur[]> {
    return this.httpClient.get<Fournisseur[]>(
      'http://localhost:8080/eshop/api/fournisseur'
    );
  }
}
