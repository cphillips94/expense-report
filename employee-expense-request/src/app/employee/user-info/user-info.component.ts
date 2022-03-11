import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeHttpService } from 'src/app/employee-http.service';
import { employee } from 'src/app/employee.model';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {
  newUser: employee = {
    userId: 0,
    firstName: "",
    lastName: "",
    userName: "",
    password: "",
    role: ""
  }


  constructor(private employeeHttpService: EmployeeHttpService, private router: Router) { }
 
  ngOnInit(): void {
    this.loadAUser();  
  }

  loadAUser(){
    this.employeeHttpService.fetchAUser(Number(sessionStorage.getItem('idNumber'))).subscribe((response)=>{
      // the response that we receive here is an array of Book
      console.log(response);
      this.newUser = response;
    });
  }



  goToEditInfo(userId: number){
    this.router.navigate(['edit-info', userId]);
  }

  addBook(){
   this.employeeHttpService.addUser(this.newUser).subscribe((response)=>{
     console.log(response);
     this.newUser= {
      userId: 0,
      firstName: "",
      lastName: "",
      userName: "",
      password: "",
      role: ""
    }
     this.loadAUser();
   })
  }
}