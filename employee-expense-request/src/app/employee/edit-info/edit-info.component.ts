import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeHttpService } from 'src/app/employee-http.service';
import { employee } from 'src/app/employee.model';
import { ViewHttpEmployeeComponent } from 'src/app/manager/view-http-employee/view-http-employee.component';

@Component({
  selector: 'app-edit-info',
  templateUrl: './edit-info.component.html',
  styleUrls: ['./edit-info.component.css']
})
export class EditInfoComponent implements OnInit {


  newUser: employee= {
    userId: 0,
    firstName: "",
    lastName: "",
    userName: "",
    password: "",
    role: ""
  }

  constructor(private activatedRoute: ActivatedRoute, 
              private employeeHttpService: EmployeeHttpService,
              private router: Router) { }


            
              ngOnInit(): void {
                // to take out the route parameter, we need to inject ActivatedRoute in the constructor
                let userId: any = this.activatedRoute.snapshot.paramMap.get("myId");
                console.log(userId);
                // fetch the book with the bookId from the service layer
               this.employeeHttpService.fetchAUser(userId).subscribe((response)=>{
                this.newUser = response;
               });
            
              }
            
              test(myTitle: any){
                console.log(myTitle);
              }
              
              updateUser(){
                this.employeeHttpService.updateUser(this.newUser).subscribe((response)=>{
                  console.log(response);
                  // once update is over navigate back to ListHttpBookComponent
                  this.router.navigate(['user-crud']);
                });
              }
            }
            