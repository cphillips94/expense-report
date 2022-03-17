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
    employeeId: 0,
    employeeFirstName: "",
    employeeLastName:"",
    employeeContact:"",
    employeePassword:""
  }
  errorMessage: string = "";
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }



  validateUser(){
    let returnUser: User = this.userService.validateUser(this.newUser);
    //sessionStorage.setItem('idNumber',JSON.stringify(returnUser.idNumber));
    


    if(returnUser.employeeFirstName== ""){
      // invalid credentials
      this.errorMessage = "Invalid Credentials!!";
    }else{
      // successful login
      if(returnUser.employeeFirstName== "employee"){
        //navigate to book-crud in the old one need to fix ??
        this.router.navigate(['user-info']);
      }else{
        //navigate to display component
        this.router.navigate(['header']);
      }
      console.log("login succesfull!!");
    }
  }
}
