import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usern: string = "username";
  userp: string = "password";


  constructor(public router: Router) { }

  ngOnInit(): void {
  }

  async submit() {

    let url="http://localhost:8090/poketrade/";

    let user = {
      poke_username: this.usern,
      poke_password: this.userp
    }

    //if (user.password == "password" && user.username == "username"){
     // this.router.navigate(['home']);

   // }

    let response = await fetch(url + "login", {

      method: "POST",

      body: JSON.stringify(user)
     

    });

    if (response.status === 200) {
      this.router.navigate(['home']);

    }
    else {
      console.log(response.status);
       console.log("failed");
    }


  }
}
