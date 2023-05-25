import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'exerciceAngular';

  onVoteEvent(event: any) {
    console.log('Nom: ' + event.nom + ', Vote: ' + event.vote);
  }
}
