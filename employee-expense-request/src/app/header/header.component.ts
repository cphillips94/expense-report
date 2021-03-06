import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from '../user/user.model';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  isLoggedIn(): boolean{
    return this.authService.loggedIn;
  }

  getRole(): string{
    let data: User = this.authService.retrieveUser();
    return data.employeeFirstName;
  }
}

