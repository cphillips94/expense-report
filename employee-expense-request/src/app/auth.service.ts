import { Injectable } from '@angular/core';
import { Manager } from './manager-log/manager.model';
import { User } from './user/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  storeManager(newManager: Manager) {
    throw new Error('Method not implemented.');
  }

  constructor() { }

  loggedIn: boolean = false;

  storeUser(user: User): void{
    sessionStorage.setItem("userInfo", JSON.stringify(user));
  }

  retrieveUser(): User{
    let data: any = sessionStorage.getItem("userInfo");
    return JSON.parse(data);
  }

  destroyUser(): void{
    sessionStorage.removeItem("userInfo");
  }
}
