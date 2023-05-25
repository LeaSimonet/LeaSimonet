export class Produit {
  constructor(private _nom?: string, private _prix?: number) {}

  nomPrix(): string {
    return 'produit :' + this._nom + ' ' + 'prix :' + this._prix; //on nepeut pas utiliser l'attribut direct, on est obligé de mettre le this.
  }

  public get nom(): string | undefined {
    return this.nom;
  }
  public set nom(value: string | undefined) {
    this.nom = value;
  }

  public get prix(): number | undefined {
    return this.prix;
  }
  public set prix(value: number | undefined) {
    this.prix = value;
  }
}
