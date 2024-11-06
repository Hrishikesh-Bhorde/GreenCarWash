import { Component } from '@angular/core';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.scss']
})
export class ProfilePageComponent {

  isEditable: boolean = false;

  profile = {
    name: 'Hrishikesh',
    profileImg: 'https://www.pngall.com/wp-content/uploads/5/Profile-Avatar-PNG.png',
    address: '123 Main St, City, Country',
    phone: '+1234567890',
    email: 'hrishi@example.com'
  };

  cars = [
    { name: 'Car 1', model: 'Model X', year: '2022', details: 'Electric vehicle, 500 km range.', isOpen: false },
    { name: 'Car 2', model: 'Model Y', year: '2021', details: 'Hybrid vehicle, 300 km range.', isOpen: false },
    { name: 'Car 3', model: 'Model Z', year: '2020', details: 'Diesel vehicle, 400 km range.', isOpen: false }
  ];

  toggleEdit() {
    this.isEditable = !this.isEditable;
  }

  toggleAccordion(car: any) {
    car.isOpen = !car.isOpen;
  }
}
