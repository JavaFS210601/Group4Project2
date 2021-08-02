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

  send(poke: any) {
    this.ts.setData(poke);
    this.router.navigate(['home/inventory']);
  }

}
