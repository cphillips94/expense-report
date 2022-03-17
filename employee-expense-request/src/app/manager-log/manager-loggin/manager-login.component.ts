import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ManagerLogService } from '../manager-log.service';
import { Manager } from '../manager.model';

@Component({
  selector: 'managerLogin',
  templateUrl: './manager-login.component.html',
  styleUrls: ['./manager-login.component.css']
})
export class LoginComponent implements OnInit {

  newManager: Manager={
    managerId: 0,
    managerFirstName: "",
    managerLastName:"",
    managerPassword:""
  }
  errorMessage: string = "";
  constructor(private managerLogService: ManagerLogService, private router: Router) { }

  ngOnInit(): void {
  }



  validateManager(){
    let returnUser: Manager = this.managerLogService.validateManager(this.newManager);
    //sessionStorage.setItem('idNumber',JSON.stringify(returnUser.idNumber));
    


    if(returnUser.managerFirstName== ""){
      // invalid credentials
      this.errorMessage = "Invalid Credentials!!";
    }else{
      // successful login
      if(returnUser.managerFirstName== "manager"){
        //navigate to book-crud in the old one need to fix ??
        this.router.navigate(['manager-info']);
      }else{
        //navigate to display component
        this.router.navigate(['header']);
      }
      console.log("login succesfull!!");
    }
  }
}
