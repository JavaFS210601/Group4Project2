import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { Router } from '@angular/router';
import { TransferServiceService } from 'src/app/services/transfer-service.service';


@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  public pokemon:any = null;
  newPokemon = this.ts.getData();
  inventoryArray = this.getArray();
  userdata:any= null;

  //if(this.newPokemon){
    // do whatever needed
  //  let sprite = this.newPokemon.sprites.front_shiny;
  //  let name = this.newPokemon.name;
  //  let replaceInt = 1;

  //  console.log(sprite);

  //  var newInventory={
  //      id: this.newPokemon.id,
  //      pokedexId: replaceInt,
  //      pokemon: name,
  //      objsprites: sprite

  //  }
  //}
  //else{
  //  console.log("Something went wrong adding new Pokemon")
  //  this.router.navigateByUrl('home/inventory');
  //}


  constructor(private ps: PokeFetchService,
    private ts: TransferServiceService,
    private router: Router) { 


    }

  ngOnInit(): void {
  }

   getArray():any[] {
    let Array:any = [];
   let sprite = "";
   let name = "";
   let replaceInt = 0;
   this.getUserData();
   for(let i=0;i<=this.userdata.length;i++){

      this.ps.getPokemonFromApi(this.userdata[i].poke_id_fk).subscribe(


        (data:Pokemon) => { this.pokemon=data;
                      console.log(this.pokemon)
                      sprite = this.pokemon.sprites.front_shiny;
                      name = this.pokemon.name;


                      console.log(sprite);


                      var inventoryInfo={
                          id: this.userdata[i].inventory_id,
                          pokedexId: this.userdata.poke_id_fk,
                          pokemon: name,
                          objsprites: sprite

                      }
                      Array[i]=inventoryInfo;

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

 open(inventoryInfo: any) {
  this.ts.setData(inventoryInfo);
  this.router.navigate(['singletrade']);
}

async getUserData(){
  let url="http://localhost:8090/poketrade/";
   var response = await fetch(url+'inventory');
   console.log(response)
   this.userdata= await response.json();
   
}

}