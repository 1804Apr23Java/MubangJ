import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';

import { NgModule, Pipe } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { HomeComponent } from './home/home.component';
import { MeatsComponent } from './meats/meats.component';
import { CobblerComponent } from './cobbler/cobbler.component';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'meats', component: MeatsComponent },
  { path: 'cobbler', component: CobblerComponent },
];
@NgModule({
  declarations: [
    HomeComponent,
    MeatsComponent,
    CobblerComponent,
    NavComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
