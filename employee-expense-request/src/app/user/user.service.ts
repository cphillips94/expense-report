import { Injectable } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private authService: AuthService) { }

  validateUser(newUser: User): User{
    if(newUser.employeeFirstName=="employee" && newUser.employeePassword=="employee"){
      // user has succesfully logged in as an admin
      // 1. store the user information in the browser storage
      this.authService.storeUser(newUser);
      // 2. mark that we have logged in
      this.authService.loggedIn=true;

    }else{
      // invalid credentials
      newUser={
      employeeId: 0,
      employeeFirstName: "",
      employeeLastName:"",
      employeeContact:"",
      employeePassword:""
  }

    }
    return newUser;
  }
}
