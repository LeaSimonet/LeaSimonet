import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FournisseurListComponent } from './components/fournisseur/fournisseur-list/fournisseur-list.component';
import { FournisseurEditComponent } from './components/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { MenuComponent } from './components/menu/menu.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { ProduitEditComponent } from './components/produit/produit-edit/produit-edit.component';
import { ProduitListComponent } from './components/produit/produit-list/produit-list.component';

@NgModule({
  declarations: [
    AppComponent,
    FournisseurListComponent,
    FournisseurEditComponent,
    MenuComponent,
    HomeComponent,
    ProduitEditComponent,
    ProduitListComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
