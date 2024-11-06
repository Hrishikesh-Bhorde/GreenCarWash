import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  constructor(private service : UserService)
  {}


  ngOnInit(): void {
    
  }

  email:string = "plus@gmail.com";
  password:string = "pls@123";

  login = () =>{
    this.service.loginUser(this.email, this.password);
  }


}
