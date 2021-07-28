import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokeFetchService} from 'src/app/services/poke-fetch.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public input:number = 0;
  public pokemon:any = null;

  constructor(private ps:PokeFetchService) { }

  ngOnInit(): void {
  }

   getPoke():void {

    this.ps.getPokemonFromApi(this.input).subscribe(

      (data:Pokemon) => { console.log(data.name); }, 
      () => {
        this.pokemon = null;
        console.log("Something is wrong I can feel it (pokemon retrieval).");
      }

    )

   }

}
