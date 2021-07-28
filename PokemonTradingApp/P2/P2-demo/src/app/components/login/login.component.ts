import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string = "";
  password:string ="";
  

  constructor(public router:Router) { }

  ngOnInit(): void {
  }

  submit() {
    if(this.username==='username' && this.password==='password'){
      console.log("success!");
      this.router.navigate(['home']);
    }
  }
}
