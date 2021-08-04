import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { TransferServiceService } from 'src/app/services/transfer-service.service';


@Component({
  selector: 'app-single-offer',
  templateUrl: './single-offer.component.html',
  styleUrls: ['./single-offer.component.css']
})
export class SingleOfferComponent implements OnInit {

  public pokemon: any = null;
  inventory:any = [];

  

  userdata:any=[null,null,null,null,null,null,null,null,null,null,null,null,null,null];
  selectedValue: number = 0;
  username: string = "";
  hiddenValue: boolean = false;
  hiddenValue2: boolean = true;
  offer: any = this.ts.getData();

  temp:any= this.getUserData();

  
  constructor(private ps: PokeFetchService,
    private ts: TransferServiceService) {

  }

  ngOnInit(): void {

  }
  makeOffer() {
    this.hiddenValue = true;
    this.hiddenValue2 = false;
  }

   async submitOffer() {
     let url="http://localhost:8090/poketrade/";
     
     for(let i=0;i<this.userdata.length;i++){
       if(this.userdata[i].inventory_id==this.selectedValue){
         console.log(this.userdata[i]);

         let sendinginventory = this.userdata[i];
         let replyOffer={
           offer_id: this.offer.id,
           inventory: sendinginventory
         }

         
        let response = await fetch(url + "offer/replyoffer", {

       method: "POST",
      
       body: JSON.stringify(replyOffer)
     

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

  getInventory(): any[] {
    let Array: any = [];
    let name: string = "";
    for(let i=0;i<this.userdata.length;i++){
      this.ps.getPokemonFromApi(this.userdata[i].poke_id_fk).subscribe(

        (data: Pokemon) => {
          this.pokemon = data;

          var poke = {
            value: this.userdata[i].inventory_id,
            name: this.pokemon.name,

          }
          Array[i] = poke;
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
   var response = await fetch(url+'inventory');  
   
   if(response.status==200){
     this.userdata= await response.json();
     
     this.inventory= this.getInventory();
      console.log("I have got user data")
     
     
   }
}

}


