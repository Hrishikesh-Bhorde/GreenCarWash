import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  base_URL: string = 'http://localhost:8089/';

  constructor(private http: HttpClient) {}

  loginUser = (email: String, pass: String) => {
    const body = {
      email: email,
      password: pass,
    };
    this.http.post(this.base_URL + 'users/login', body).subscribe({
      next: (response) => {
        console.log(response);
      },
      error: (error) => console.log(error),
    });
  };

  registerUser = (email: string, password: string, registerAs: string) => {
    const body = {
      email: email,
      password: password,
    };

    if (registerAs == 'WASHER') {
      this.http.post(this.base_URL + 'users/washer/register', body).subscribe({
        next: (response) => {
          console.log(response);
        },
        error: (error) => console.log(error),
      });
    } else if (registerAs == 'CLIENT') {
      this.http.post(this.base_URL + 'users/client/register', body).subscribe({
        next: (response) => {
          console.log(response);
        },
        error: (error) => console.log(error),
      });
    }
  };

  updateProfile = (id : any, name : string, address : string, phoneNo : string, profilePic : string) =>{
    const body = {
      "name" : name,
      "address" : address,
      "phoneNo" : phoneNo,
      "profilePic" : profilePic
    }
    this.http.put(`${this.base_URL}/users/update/${id}`, body).subscribe({
      next: (response) => {
        console.log(response);
      },
      error: (error) => console.log(error),
    });
  }

}
