import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../models/pokemon';


@Injectable({
  providedIn: 'root'
})
export class PokeFetchService {

  constructor(private http:HttpClient) { }

  getPokemonFromApi(id:number):Observable<Pokemon> { //this function returns an obsservable of type pokemon
    return this.http.get("https://pokeapi.co/api/v2/pokemon/" + id + "/") as Observable<Pokemon>
  }
}
