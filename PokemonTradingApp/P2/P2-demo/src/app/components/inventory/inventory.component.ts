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
  // holder =this.get
  inventoryArray = this.getArray();
  constructor(private ps: PokeFetchService,
    private ts: TransferServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  getArray():any[] {
    let Array:any = [];
   let sprite = "";
   let name = "";
   let replaceInt = 1;
    
   //for loop to bring in the pokemon that have an id of 1-6
   for(let i=0;i<=6;i=i+1){
     
      this.ps.getPokemonFromApi(i+1).subscribe(

     (data:Pokemon) => { this.pokemon=data;
                      sprite = this.pokemon.sprites.front_shiny;
                      name = this.pokemon.name;


                      console.log(sprite);
                         
                       
                      var inventoryInfo={
                          id: i+1,
                          pokedexId: replaceInt,
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

}