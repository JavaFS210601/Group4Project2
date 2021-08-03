import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { Router } from '@angular/router';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { TransferServiceService } from 'src/app/services/transfer-service.service';

@Component({
  selector: 'app-poke-result',
  templateUrl: './poke-result.component.html',
  styleUrls: ['./poke-result.component.css']
})
export class PokeResultComponent implements OnInit {

  pokemon = this.ts.getData();
  username:string = "";
  //input = 56;  //this.ts.getData().poke.input;

  constructor(private ts: TransferServiceService,
    private ps: PokeFetchService,
    private router: Router) { }

  ngOnInit(): void {
  }

  getPoke() {

    console.log(this.pokemon);
    this.send(this.pokemon);

    //this.ps.getPokemonFromApi(this.pokemon.id).subscribe(

      //(data: Pokemon) => {
      //  this.pokemon = data;
        
     // },
      //() => {
     //   this.pokemon = null;
      //  console.log("Something is wrong I can feel it (pokemon retrieval).");
      //}

    //)
  }

  async send(poke: any) {
    let url="http://localhost:8090/poketrade/";
     let invetory = {
      poke_username: this.username,
      poke_id_fk: poke.id
    }
    let response = await fetch(url + "inventory", {

      method: "POST",
      
      body: JSON.stringify(invetory)
     

    });

  if (response.status === 200) {
      console.log("Success")


    }
    else {
      console.log(response.status);
      console.log("failed");
    }
    this.router.navigate(['home/inventory']);
  }

}
