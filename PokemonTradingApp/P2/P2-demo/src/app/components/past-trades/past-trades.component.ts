import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';

@Component({
  selector: 'app-past-trades',
  templateUrl: './past-trades.component.html',
  styleUrls: ['./past-trades.component.css']
})
export class PastTradesComponent implements OnInit {

  public pokemon: any = null;

  public pokemon2:any =null;

   userdata:any=[null,null,null,null,null,null,null,null,null,null,null,null,null,null];

   temp:any= this.getUserData();

  // holder =this.get
   offerArray:any = [];
  hiddenValue: boolean = false;
  constructor(private ps: PokeFetchService) { }

  ngOnInit(): void {
  }

  getArray(): any[] {
    let Array: any = [];
    let sprite = "";
    let name = "";

    for(let i=0;i<this.userdata.length;i++){

      this.hiddenValue = true;

      var secondary = "";
      var offered = "";
      this.ps.getPokemonFromApi(this.userdata[i].primary_inventory_id.poke_id_fk).subscribe(

        (data: Pokemon) => {
          this.pokemon = data;

          name = this.pokemon.name;
          console.log(name);
          
            secondary = this.userdata[i].reply_inventory_id.user_id_fk;


            this.ps.getPokemonFromApi(this.userdata[i].reply_inventory_id.poke_id_fk).subscribe( (data: Pokemon) => {

               this.pokemon2 = data;

          offered = this.pokemon2.name;

            var offer = {
            id: this.userdata[i].offer_pool_id,
            user:this.userdata[i].primary_inventory_id.user_id_fk ,
            pokemon: name,
            second: this.userdata[i].primary_inventory_id.user_id_fk,
            offeredPoke: offered

          }
          Array[i] = offer;

            },
            () => {
          this.pokemon = null;
          console.log("Something is wrong I can feel it (pokemon retrieval).");
        }
        )
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

  async getUserData(){
  let url="http://localhost:8090/poketrade/";
  console.log("I am coming to get user data")
   var response = await fetch(url+'offer/userpastoffer');  
   
   if(response.status==200){
     this.userdata= await response.json();
     
     this.offerArray= this.getArray();
      console.log("I have got user data")
     
     
   }
}

}
