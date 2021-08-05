import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';

@Component({
  selector: 'app-my-open-trades',
  templateUrl: './my-open-trades.component.html',
  styleUrls: ['./my-open-trades.component.css']
})
export class MyOpenTradesComponent implements OnInit {

  offerId: number = 0;
  decision: number = 0;
  formHidden: boolean = true;
  headerHidden: boolean = true;
  buttonHidden: boolean = false;
  public pokemon: any = null;
  public pokemon2:any =null;

   userdata:any=[null,null,null,null,null,null,null,null,null,null,null,null,null,null];

   temp:any= this.getUserData();

  // holder =this.get
   offerArray:any = [];
  // holder =this.get
 
  constructor(private ps: PokeFetchService) { }

  ngOnInit(): void {
  }
  getArray(): any[] {
    let Array: any = [];
    let sprite = "";
    let name = "";

    for(let i=0;i<this.userdata.length;i++){

     console.log("OPen trade getting")

      var secondary = "";
      var offered = "";
      this.ps.getPokemonFromApi(this.userdata[i].primary_inventory_id.poke_id_fk).subscribe(

        (data: Pokemon) => {
          this.pokemon = data;

          name = this.pokemon.name;
          console.log(name);
           var offer = {
            id: this.userdata[i].offer_pool_id,
            user:this.userdata[i].primary_inventory_id.user_id_fk ,
            pokemon: name

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
  deleteOffer() {
    this.formHidden = false;
    this.buttonHidden = true;
  }
  submit() {
    console.log(this.decision);
    console.log(this.offerId);
  }

  onChange(entry: number): void {
    this.decision = entry;
  }

  async getUserData(){
  let url="http://localhost:8090/poketrade/";
  console.log("I am coming to get user data")
   var response = await fetch(url+'offer/useropenoffer');  
   
   if(response.status==200){
     this.userdata= await response.json();
     
     this.offerArray= this.getArray();
      console.log("I have got user data")
     
     
   }
}

}
