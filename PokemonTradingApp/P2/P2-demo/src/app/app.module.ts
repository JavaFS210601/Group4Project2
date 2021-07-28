import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokeBannerComponent } from './components/poke-banner/poke-banner.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './components/signup/signup.component';
import { InventoryComponent } from './components/inventory/inventory.component';
import { OpenTradesComponent } from './components/open-trades/open-trades.component';
import { PendingTradesComponent } from './components/pending-trades/pending-trades.component';
import { MyOpenTradesComponent } from './components/my-open-trades/my-open-trades.component';
import { PastTradesComponent } from './components/past-trades/past-trades.component';

@NgModule({
  declarations: [
    AppComponent,
    PokeBannerComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    InventoryComponent,
    OpenTradesComponent,
    PendingTradesComponent,
    MyOpenTradesComponent,
    PastTradesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
