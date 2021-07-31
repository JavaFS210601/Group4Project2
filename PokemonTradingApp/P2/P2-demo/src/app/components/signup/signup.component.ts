import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  username:string = "";
  password1:string ="";
  name:string = "";
  password2:string ="";
  phone:string='';

  constructor(public router:Router) { }

  ngOnInit(): void {
  }

  async submit(){
    if(this.name===''||this.username===''||this.password1===''||this.password2===''||this.phone===''){
      console.log("Empty field");
      alert("Empty field");
      this.router.navigate(['signup']);
    }
    else if(this.password1!= this.password2){
     
      console.log("password mismatch");
      alert("password mismatch");
      this.router.navigate(['signup']);
    }

    
    else{
      let url="http://localhost:8090/poketrade/";
       let user = {
      poke_username: this.username,
      poke_password: this.password1,
      poke_full_name: this.name,
      poke_contact_info: this.phone
       }
        let response = await fetch(url + "signup", {

      method: "POST",
      
      body: JSON.stringify(user)
     

      });

      if (response.status === 200) {
        alert("Signup successful");
      this.router.navigate(['login']);

    }
    else {
      console.log(response.status);
      this.router.navigate(['signup']);
    }


    
    }
    }
      
    }


