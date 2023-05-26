import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-matiere-preferee',
  templateUrl: './matiere-preferee.component.html',
  styleUrls: ['./matiere-preferee.component.css'],
})
export class MatierePrefereeComponent {
  matierePreferee = '';
  vote = 0;
  tabMatieres = ['java', 'uml', 'rstudio', 'angular'];
  nouvelleMatiere: string = '';

  ajouterMatiere() {
    if (this.nouvelleMatiere) {
      this.tabMatieres.push(this.nouvelleMatiere);
      this.nouvelleMatiere = ''; // Réinitialise le champ de saisie de la nouvelle matière après l'ajout
    }
  }

  getVote(obj: any) {
    if (obj.vote > this.vote) {
      this.vote = obj.vote;
      this.matierePreferee = obj.nom;
    }
  }
}
