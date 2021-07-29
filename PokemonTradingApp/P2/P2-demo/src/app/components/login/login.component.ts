import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usern:string = "";
  userp:string ="";
  

  constructor(public router:Router) { }

  ngOnInit(): void {
  }

   async submit() {

    let url;

    let user = {
        username: this.usern,
        password: this.userp
    }

    let response = await fetch (url + "login",{

        method: "POST",

        body: JSON.stringify(user)

    });
    
      if(response.status === 200){
        this.router.navigate(['home']);
      }
      
    
  }
}
