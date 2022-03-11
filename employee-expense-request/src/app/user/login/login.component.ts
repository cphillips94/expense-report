import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user/user.service';
import { User } from '../user.model';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  newUser: User={
    userName: "",
    password: "",
    role: "",
    idNumber: 0
  }
  errorMessage: string = "";
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }



  validateUser(){
    let returnUser: User = this.userService.validateUser(this.newUser);
    sessionStorage.setItem('idNumber',JSON.stringify(returnUser.idNumber));
    


    if(returnUser.userName == ""){
      // invalid credentials
      this.errorMessage = "Invalid Credentials!!";
    }else{
      // successful login
      if(returnUser.role == "admin"){
        //navigate to book-crud
        this.router.navigate(['view-users']);
      }else{
        //navigate to display component
        this.router.navigate(['header']);
      }
      console.log("login succesfull!!");
    }
  }
}
