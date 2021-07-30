import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';

@Component({
  selector: 'app-my-open-trades',
  templateUrl: './my-open-trades.component.html',
  styleUrls: ['./my-open-trades.component.css']
})
export class MyOpenTradesComponent implements OnInit {
  
  hiddenValue:boolean =true;
   public pokemon:any = null;
  // holder =this.get
  offerArray = this.getArray();
  constructor(private ps:PokeFetchService) { }

  ngOnInit(): void {
  }
  getArray():any[] {
     let Array:any=[];
    let sprite="";
    let name="";
    if(true){this.hiddenValue=true;}
     
    
    for(let i=0;i<=6;i=i+1){
      
       
      
      var secondary="";
      var offered="";
       this.ps.getPokemonFromApi(i+1).subscribe(

      (data:Pokemon) => { this.pokemon=data;
                       
                        name=this.pokemon.name;
                        console.log(name);
                          
                        
                        var offer={
                            id:i+1,
                            user:"Ash",
                            pokemon: name,
                        }
                        Array[i]=offer;

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

}
