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
  
  userdata:any=[null,null,null,null,null,null,null,null,null,null,null,null,null,null];
  pokedata:any=[null];
  
  inventoryArray:any = [];
  temp:any= this.getUserData();
   


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
  
   
    
   
   for(let i=0;i<this.userdata.length;i++){
    let sprite = "";
    let name = "";
    this.ps.getPokemonFromApi(this.userdata[i].poke_id_fk).subscribe(

        (data: Pokemon) => {
          this.pokemon = data;
          sprite = this.pokemon.sprites.front_shiny;
          name = this.pokemon.name;
          console.log(sprite);
          var offer = {
            id: this.userdata[i].inventory_id,
            pokedexId:this.userdata[i].poke_id_fk ,
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

 open(inventoryInfo: any) {
  this.ts.setData(inventoryInfo);
  this.router.navigate(['singletrade']);
}

async getUserData(){
  let url="http://localhost:8090/poketrade/";
  console.log("I am coming to get user data")
   var response = await fetch(url+'inventory');  
   
   if(response.status==200){
     this.userdata= await response.json();
     
     this.inventoryArray= this.getArray();
      console.log("I have got user data")
     
     
   }
}

// async getPokemon(id:number){
  
//   console.log("I am coming to data for poke")
//    var response = await fetch("https://pokeapi.co/api/v2/pokemon/" + id + "/");  
   
   
    
//      this.pokedata[0]= await response.json();
   
//      this.sprite = this.pokedata[0].sprites.front_shiny;
//       console.log(this.sprite)

//       // if(this.pokedata[0].id)

    
     
     
 
// }

}