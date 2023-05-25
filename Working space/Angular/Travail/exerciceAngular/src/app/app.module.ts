import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MatiereComponent } from './matiere/matiere.component';
import { MatierePrefereeComponent } from './matiere-preferee/matiere-preferee.component';

@NgModule({
  declarations: [
    AppComponent,
    MatiereComponent,
    MatierePrefereeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
