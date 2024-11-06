import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-bar',
  templateUrl: './profile-bar.component.html',
  styleUrls: ['./profile-bar.component.scss']
})
export class ProfileBarComponent implements OnInit {

  @Input() loginDetails:any;
  user:any;

  constructor(private router : Router){}

  ngOnInit(): void {
// throw new Error('Method not implemented.');
  }

  gotoLogin(){
    this.router.navigate(["/login"])
  }

  

}
