import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { employee } from './employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeHttpService {

  constructor(private http: HttpClient) { }

  fetchAllUsers(): Observable<employee[]>{
    // we need to work with HttpClient to consume an endpoint
    return this.http.get<employee[]>("http://localhost:4040/api/users");
  }


  addUser(employeeModel: employee): Observable<employee>{
    return this.http.post<employee>("http://localhost:4040/api/users", JSON.stringify(employeeModel));
  }

  updateUser(employeeModel: employee): Observable<employee>{
    return this.http.put<employee>("http://localhost:4040/api/users", JSON.stringify(employeeModel));
  }

  fetchAUser(userId: number): Observable<employee>{
    return this.http.get<employee>("http://localhost:4040/api/users/"+userId);
  }
}

 