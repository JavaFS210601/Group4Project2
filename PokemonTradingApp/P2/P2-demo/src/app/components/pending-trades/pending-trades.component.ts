import { Component, OnInit } from '@angular/core';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { Pokemon } from 'src/app/models/pokemon';

@Component({
  selector: 'app-pending-trades',
  templateUrl: './pending-trades.component.html',
  styleUrls: ['./pending-trades.component.css']
})
export class PendingTradesComponent implements OnInit {

  public pokemon:any = null;
  // holder =this.get
  offerArray = this.getArray();
  hiddenValue:boolean = true;
  constructor(private ps:PokeFetchService) { }
  
  ngOnInit(): void {
  }
  getArray():any[]{
    let Array:any=[];
    let sprite="";
    let name="";
    if(true){this.hiddenValue=true;}
     
    
    for(let i=0;i<=13;i=i+1){
      
       
      
      var secondary="";
      var offered="";
       this.ps.getPokemonFromApi(i+1).subscribe(

      (data:Pokemon) => { this.pokemon=data;
                       
                        name=this.pokemon.name;
                        console.log(name);
                          if(i%2==0){
                          secondary="Misty";
                          offered="Charizard";
                          }
                          else {
                            secondary="Brock";
                          offered="Onix";
                          }
                        
                        var offer={
                            id:i+1,
                            user:"Ash",
                            pokemon: name,
                            second:secondary,
                            offeredPoke:offered
                            
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
