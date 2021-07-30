import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransferServiceService } from 'src/app/services/transfer-service.service';

@Component({
  selector: 'app-poke-result',
  templateUrl: './poke-result.component.html',
  styleUrls: ['./poke-result.component.css']
})
export class PokeResultComponent implements OnInit {

  pokemon = this.ts.getData();

  constructor(private ts: TransferServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

}
