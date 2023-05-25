export class Personne {
  //attributs

  // private prenom: string | undefined; // private prenom?: string;
  // private nom: string;

  //Constructeur : je ne peux fair qu'un seul constructeur ! Contrairmeent à Java où je peux en avoir plusieurs. Mais je peux tricher dans mon unique constructeur en jouant sur sa signature
  // le fameux doe.
  // Si je veux un undefinied (nom?) je dois d'abord préciser dans les attributs que ça peut être un string ou undefinied.
  // constructor(prenom?: string, nom: string = 'doe') {
  //   this.prenom = prenom;
  //   this.nom = nom;
  // }

  constructor(
    private _prenom?: string,
    private _nom?: string,
    private _photo?: string
  ) {}

  sePresenter(): string {
    //On met le type de retour que si on en a besoin, sinon c'est void.
    return this.prenom + '' + this._nom; //on nepeut pas utiliser l'attribut direct, on est obligé de mettre le this.
  }

  get prenom(): string | undefined {
    return this._prenom;
  }

  set prenom(value: string | undefined) {
    this._prenom = value;
  }

  get nom(): string | undefined {
    return this._nom;
  }
  set nom(value: string | undefined) {
    this._nom = value;
  }

  public get photo(): string | undefined {
    return this._photo;
  }
  public set photo(value: string | undefined) {
    this._photo = value;
  }
}

// new Personne('prenom', 'nom')
