import { Injectable } from '@angular/core';
import { Manager } from './manager.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  loggedIn: boolean = false;

  storeManager (Manager: Manager): void{
    sessionStorage.setItem("managerInfo", JSON.stringify(Manager));
  }
  
  retrieveManager(): Manager{
    let data: any = sessionStorage.getItem("managerInfo");
    return JSON.parse(data);
  }
  
  destroyManager(): void{
    sessionStorage.removeItem("managerInfo");
  }
}