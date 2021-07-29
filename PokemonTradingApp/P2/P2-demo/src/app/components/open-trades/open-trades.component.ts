import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pokemon } from 'src/app/models/pokemon';


import { PokeFetchService } from 'src/app/services/poke-fetch.service';

@Component({
  selector: 'app-open-trades',
  templateUrl: './open-trades.component.html',
  styleUrls: ['./open-trades.component.css']
})
export class OpenTradesComponent implements OnInit {
  public pokemon:any = null;
  // holder =this.get
  offerArray = this.getArray();
  constructor(private ps:PokeFetchService) { 
  }

  ngOnInit(): void {

  }

   getArray():any[]{
    let Array:any=[];
    let sprite="";
    let name="";
    for(let i=0;i<13;i++){
       this.ps.getPokemonFromApi(i+1).subscribe(

      (data:Pokemon) => { this.pokemon=data;
                        sprite= this.pokemon.sprites.front_shiny;
                        name=this.pokemon.name;
                        console.log(sprite);
                        var offer={
                            id:i+1,
                            user:i+1,
                            pokemon: name,
                            objsprites: sprite
                        }
                        Array[i]=offer;
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


