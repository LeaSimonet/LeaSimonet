import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BonjourComponent } from './bonjour/bonjour.component';
import { PersonneComponent } from './personne/personne.component';
import { FormsModule } from '@angular/forms';
import { FormPersonneComponent } from './form-personne/form-personne.component';
import { AfficherProduitComponent } from './afficher-produit/afficher-produit.component';
import { FormProduitComponent } from './form-produit/form-produit.component';
import { ProduitComponent } from './produit/produit.component';
import { DemoDirectiveComponent } from './demo-directive/demo-directive.component';

@NgModule({
  declarations: [
    AppComponent,
    BonjourComponent,
    PersonneComponent,
    FormPersonneComponent,
    AfficherProduitComponent,
    FormProduitComponent,
    ProduitComponent,
    DemoDirectiveComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule, //gère les formulaires en ANgular
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
