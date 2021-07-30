import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-poke-banner',
  templateUrl: './poke-banner.component.html',
  styleUrls: ['./poke-banner.component.css']
})
export class PokeBannerComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  goHome() {
    this.router.navigate(['home']);
  }
  go(path: string) {
    this.router.navigate(['home/' + path]);
  }

}
