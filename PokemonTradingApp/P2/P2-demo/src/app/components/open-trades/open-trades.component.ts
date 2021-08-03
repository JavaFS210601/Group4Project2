import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pokemon } from 'src/app/models/pokemon';


import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { TransferServiceService } from 'src/app/services/transfer-service.service';

@Component({
  selector: 'app-open-trades',
  templateUrl: './open-trades.component.html',
  styleUrls: ['./open-trades.component.css']
})
export class OpenTradesComponent implements OnInit {
  public pokemon: any = null;

  userdata:any=[null,null,null,null,null,null,null,null,null,null,null,null,null,null];

  temp:any= this.getUserData();


  // holder =this.get
  offerArray:any = [];
  constructor(private ps: PokeFetchService,
    private ts: TransferServiceService,
    private router: Router) {
  }

  ngOnInit(): void {

  }

  getArray(): any[] {
    let Array: any = [];
    let sprite = "";
    let name = "";
    for(let i=0;i<this.userdata.length;i++){
      this.ps.getPokemonFromApi(this.userdata[i].primary_inventory_id.poke_id_fk).subscribe(

        (data: Pokemon) => {
          this.pokemon = data;
          sprite = this.pokemon.sprites.front_shiny;
          name = this.pokemon.name;
          console.log(sprite);
          var offer = {
            id: this.userdata[i].offer_pool_id,
            user: this.userdata[i].primary_inventory_id.user_id_fk,
            pokemon: name,
            objsprites: sprite
          }
          Array[i] = offer;
        },
        () => {
          this.pokemon = null;
          console.log("Something is wrong I can feel it (pokemon retrieval).");
        }
      )
    }
    return Array;

  }


  async getUserData(){
  let url="http://localhost:8090/poketrade/";
  console.log("I am coming to get user data")
   var response = await fetch(url+'offer');  
   
   if(response.status==200){
     this.userdata= await response.json();
     
     this.offerArray= this.getArray();
      console.log("I have got user data")
     
     
   }
}

  open(offer: any) {
    this.ts.setData(offer);
    this.router.navigate(['singleoffer']);
  }

}


