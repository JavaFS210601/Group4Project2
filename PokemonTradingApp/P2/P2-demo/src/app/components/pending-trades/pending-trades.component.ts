import { Component, OnInit } from '@angular/core';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { Pokemon } from 'src/app/models/pokemon';

@Component({
  selector: 'app-pending-trades',
  templateUrl: './pending-trades.component.html',
  styleUrls: ['./pending-trades.component.css']
})
export class PendingTradesComponent implements OnInit {
  decision: number = 0;
  offerID: number = 0;
  public pokemon: any = null;
  // holder =this.get
  offerArray = this.getArray();
  hiddenValue: boolean = true;
  constructor(private ps: PokeFetchService) { }

  ngOnInit(): void {
  }
  getArray(): any[] {
    let Array: any = [];
    let sprite = "";
    let name = "";
    if (true) { this.hiddenValue = true; }


    for (let i = 0; i <= 6; i = i + 1) {



      var secondary = "";
      var offered = "";
      this.ps.getPokemonFromApi(i + 100).subscribe(

        (data: Pokemon) => {
          this.pokemon = data;

          name = this.pokemon.name;
          console.log(name);
          if (i % 2 == 0) {
            secondary = "Misty";
            offered = "Charizard";
          }
          else {
            secondary = "Brock";
            offered = "Onix";
          }

          var offer = {
            id: i + 1,
            user: "Ash",
            pokemon: name,
            second: secondary,
            offeredPoke: offered

          }
          Array[i] = offer;

        },
        () => {
          this.pokemon = null;
          console.log("Something is wrong I can feel it (pokemon retrieval).");
        }
      )
    }
    console.log(Array);
    return Array;

  }

  onChange(entry: number): void {
    this.decision = entry;
  }

  async submit() {

     let url="http://localhost:8090/poketrade/";

     let data={
       offer_id:this.offerID
     }
    if(this.decision===1){
      let response=  await fetch(url + "offer/acceptoffer",{
         method: "POST",
      
      body: JSON.stringify(data)
      });

      if (response.status === 200) {
      console.log("Success")


    }
    else {
      console.log(response.status);
      console.log("failed");
    }
    }
    else if(this.decision===2){
      let response=  await fetch(url + "offer/declineoffer",{
         method: "POST",
      
      body: JSON.stringify(data)
      });

      if (response.status === 200) {
      console.log("Success")


    }
    else {
      console.log(response.status);
      console.log("failed");
    }


    }
  }

}
