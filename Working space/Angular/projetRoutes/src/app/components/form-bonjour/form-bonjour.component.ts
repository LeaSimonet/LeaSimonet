import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-bonjour',
  templateUrl: './form-bonjour.component.html',
  styleUrls: ['./form-bonjour.component.css'],
})
export class FormBonjourComponent {
  nom!: string;

  constructor(private router: Router) {}

  envoyer() {
    this.router.navigateByUrl('/bonjour/' + this.nom);
  }
}
