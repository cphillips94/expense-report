import { Component, OnInit } from '@angular/core';
import { employee } from '../../employee.model';
import { Router } from '@angular/router';
import {EmployeeHttpService} from '../../employee-http.service';

@Component({
  selector: 'app-view-http-employee',
  templateUrl: './view-http-employee.component.html',
  styleUrls: ['./view-http-employee.component.css']
})
export class ViewHttpEmployeeComponent implements OnInit {
  allUsers: employee[] = [];
  toggleAdd: boolean = false;

  newUser: employee = {
    employeeId: 0,
    employeeFirstName: "",
    employeeLastName: "",
    employeeContact: "",
    employeePassword: "",
 
  }


  constructor(private employeeHttpService: EmployeeHttpService, private router: Router) { }

  ngOnInit(): void {
    this.loadAllUsers();
  }

  loadAllUsers(){
    this.employeeHttpService.fetchAllUsers().subscribe((response)=>{
      console.log(response);
      this.allUsers= response;
    });
  }
  toggleAddForm(){
    if(this.toggleAdd){
      this.toggleAdd = false;
  }else{
    this.toggleAdd = true;
  }
  }


  goToEditUser(userId: Number){
    this.router.navigate(['view-users', userId]);
  }



  addUser(){
    this.employeeHttpService.addUser(this.newUser).subscribe((response)=>{
      console.log(response);
      this.newUser={
        employeeId: 0,
        employeeFirstName: "",
        employeeLastName: "",
        employeeContact: "",
        employeePassword: "",
     
      }
      this.loadAllUsers();
    })
  }
  }

