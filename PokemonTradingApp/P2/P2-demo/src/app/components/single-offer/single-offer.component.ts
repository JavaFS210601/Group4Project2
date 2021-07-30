import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { TransferServiceService } from 'src/app/services/transfer-service.service';

@Component({
  selector: 'app-single-offer',
  templateUrl: './single-offer.component.html',
  styleUrls: ['./single-offer.component.css']
})
export class SingleOfferComponent implements OnInit {

  public pokemon: any = null;
  inventory = this.getInventory();
  selectedValue: number = 0;
  username: string = "";
  hiddenValue: boolean = false;
  hiddenValue2: boolean = true;
  offer: any = this.ts.getData();

  constructor(private ps: PokeFetchService,
    private ts: TransferServiceService) {

  }

  ngOnInit(): void {

  }
  makeOffer() {
    this.hiddenValue = true;
    this.hiddenValue2 = false;
  }

  submitOffer() {
    console.log("hello")
    console.log(this.username);
    console.log(this.selectedValue);
  }

  getInventory(): any[] {
    let Array: any = [];
    let name: string = "";
    for (let i = 0; i < 9; i++) {
      this.ps.getPokemonFromApi(i + 1).subscribe(

        (data: Pokemon) => {
          this.pokemon = data;

          var poke = {
            value: i + 1,
            name: this.pokemon.name,

          }
          Array[i] = poke;
        },
        () => {
          this.pokemon = null;
          console.log("Something is wrong I can feel it (pokemon retrieval).");
        }
      )
    }
    return Array;
  }

}


