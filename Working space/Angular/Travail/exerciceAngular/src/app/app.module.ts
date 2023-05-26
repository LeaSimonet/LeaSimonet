import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MatiereComponent } from './matiere/matiere.component';
import { MatierePrefereeComponent } from './matiere-preferee/matiere-preferee.component';
import { FormsModule } from '@angular/forms';
import { BackgroundDirective } from './directives/background.directive';
import { RouterModule, Routes } from '@angular/router';
import { ProduitDetailComponent } from './produit-detail/produit-detail.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  { path: 'sondage', component: MatierePrefereeComponent },
  { path: 'produit/:id', component: ProduitDetailComponent },
  { path: 'matiere', component: MatiereComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }, // obligée d'avoir la ligne du dessus.
  {
    path: '**',
    component: NotFoundComponent,
  }, // n'importe quelle route.
];

@NgModule({
  declarations: [
    AppComponent,
    MatiereComponent,
    MatierePrefereeComponent,
    BackgroundDirective,
    ProduitDetailComponent,
    HomeComponent,
    NotFoundComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
