import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'managerLogout',
  templateUrl: './manager-logout.component.html',
  styleUrls: ['./manager-logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
        // destroy the user info stored in sessionStorage
        this.authService.destroyManager();
        // mark that the person has logged out
        this.authService.loggedIn=false;
        // navigate to LoginComponent
        this.router.navigate(['login']);
  }

}
