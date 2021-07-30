import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { InventoryComponent } from './components/inventory/inventory.component';
import { MyOpenTradesComponent } from './components/my-open-trades/my-open-trades.component';
import { OpenTradesComponent } from './components/open-trades/open-trades.component';
import { PastTradesComponent } from './components/past-trades/past-trades.component';
import { PendingTradesComponent } from './components/pending-trades/pending-trades.component';
import { SingleOfferComponent } from './components/single-offer/single-offer.component';
import { PokeResultComponent } from './components/poke-result/poke-result.component';

const routes: Routes = [
  {
    path: "home",
    component: HomeComponent
  },
  {
    path: "",
    component: LoginComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'home/inventory',
    component: InventoryComponent
  },
  {
    path: 'home/myopentrades',
    component: MyOpenTradesComponent
  },
  {
    path: 'signleoffer/home/opentrades',
    component: OpenTradesComponent
  }
  ,
  {
    path: 'home/opentrades',
    component: OpenTradesComponent
  },
  {
    path: 'home/pasttrades',
    component: PastTradesComponent
  },
  {
    path: 'home/pendingtrades',
    component: PendingTradesComponent
  },
  {
    path: 'signleoffer',
    component: SingleOfferComponent
  },
  {
    path: 'pokeresult',
    component: PokeResultComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
