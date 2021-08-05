import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService } from 'src/app/services/poke-fetch.service';
import { TransferServiceService } from 'src/app/services/transfer-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public input: number = 0;
  public pokemon: any = null;

  constructor(private ps: PokeFetchService,
    private ts: TransferServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  getPoke(): void {

    this.ps.getPokemonFromApi(this.input).subscribe(

      (data: Pokemon) => {
        this.pokemon = data;
        this.show(this.pokemon);
      },
      () => {
        this.pokemon = null;
        console.log("Something is wrong I can feel it (pokemon retrieval).");
      }

    )

  }

  show(poke: any) {
    this.ts.setData(poke);
    this.router.navigate(['pokeresult']);
  }

  logout(){
    this.router.navigate(['']);
  }

}