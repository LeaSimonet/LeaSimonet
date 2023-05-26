import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  nom!: String;

  ngOnInit(): void {
    this.chemin.params.subscribe((params) => {
      this.nom = params['nom'];
    });
  }

  constructor(private chemin: ActivatedRoute) {}
}
