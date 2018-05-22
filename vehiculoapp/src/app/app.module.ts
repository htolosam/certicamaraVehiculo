import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { HeaderComponent } from './header/header-component';
import { FooterComponent } from './footer/footer-component';
import { TableroComponent } from './vehiculos/tablero/tablero.component';


//servicios
import { SuperficieService } from './servicios/superficie.service';

import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';



const routes:Routes = [
  {path: '', redirectTo:'/inicio', pathMatch: 'full'},
  {path: 'superficie', component:TableroComponent},
  {path: 'inicio', component:HomeComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    TableroComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)

  ],
  providers: [
    SuperficieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
