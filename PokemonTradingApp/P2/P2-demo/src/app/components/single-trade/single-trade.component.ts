import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { TransferServiceService } from 'src/app/services/transfer-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-single-trade',
  templateUrl: './single-trade.component.html',
  styleUrls: ['./single-trade.component.css']
})
export class SingleTradeComponent implements OnInit {

  public pokemon: any = null;
  //inventory = this.getInventory();
  selectedValue: number = 0;
  username: string = "";
  hiddenValue: boolean = false;
  hiddenValue2: boolean = true;
  trade: any = this.ts.getData();
  

  constructor(private ps: PokeFetchService,
    private ts: TransferServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  makeTrade() {
    this.hiddenValue = true;
    this.hiddenValue2 = false;
  }

  async submitTrade() {

    let offer:any = this.ts.getData;
    
     let url="http://localhost:8090/poketrade/";
     let trade = {
      
      inventory_id: offer.id,
      poke_id: offer.pokedexId

    }
    let response = await fetch(url + "offer", {

      method: "POST",
      
      body: JSON.stringify(trade)
     

    });

  if (response.status === 200) {
      console.log("Success")


    }
    else {
      console.log(response.status);
      console.log("failed");
    }
    this.router.navigate(['home/inventory']);

    


}
}
