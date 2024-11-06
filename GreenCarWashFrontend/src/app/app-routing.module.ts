import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';
import { ProfilePageComponent } from './components/profile-page/profile-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';

const routes: Routes = [
  {path:"", component:HomepageComponent},
  {path:"profile", component:ProfilePageComponent},
  {path:"login", component:LoginPageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
