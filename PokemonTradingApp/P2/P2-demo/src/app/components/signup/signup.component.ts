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

  submit(){
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
      console.log("Success");
      alert("Success!!");
      this.router.navigate(['']);
    }
      
    }
  }


