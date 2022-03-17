import { Injectable } from '@angular/core';
import { AuthService } from '../auth.service';
import { Manager } from './manager.model';

@Injectable({
  providedIn: 'root'
})
export class ManagerLogService {

  constructor(private authService: AuthService) { }

  validateManager(newManager: Manager): Manager{
    if(newManager.managerFirstName=="manager" && newManager.managerPassword=="manager"){
      // user has succesfully logged in as an admin
      // 1. store the user information in the browser storage
      this.authService.storeManager(newManager);
      // 2. mark that we have logged in
      this.authService.loggedIn=true;

    }else{
      // invalid credentials
      newManager={
      managerId: 0,
      managerFirstName: "",
      managerLastName:"",

      managerPassword:""
  }

    }
    return newManager;
  }
}