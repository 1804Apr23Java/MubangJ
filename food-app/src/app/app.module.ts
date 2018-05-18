import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { MeatsComponent } from './meats/meats.component';
import { CobblerComponent } from './cobbler/cobbler.component';
import { RouterModule, Routes } from '@angular/router';


const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'meats', component: MeatsComponent },
  { path: 'cobbler', component: CobblerComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(
    appRoutes,
    { enableTracing: true }
  ),
  BrowserModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    MeatsComponent,
    CobblerComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})



export class AppModule { }
