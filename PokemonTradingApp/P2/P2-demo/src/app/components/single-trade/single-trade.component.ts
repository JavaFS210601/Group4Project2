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

  submitTrade() {
    console.log("hello" + this.ts.getData().username + " your pokemon " + this.ts.getData().pokemon + " is on the trade block")
    console.log(this.ts.getData());
    this.router.navigate(['home/opentrades']);
  }

}
