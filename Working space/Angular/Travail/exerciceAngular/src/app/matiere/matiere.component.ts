import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.css'],
})
export class MatiereComponent {
  @Input()
  nom!: string;
  vote: number = 0;

  @Output()
  voteEvent: EventEmitter<any> = new EventEmitter<any>();

  incrementVote() {
    this.vote++;
    this.voteEvent.emit({ nom: this.nom, vote: this.vote });
  }
}
