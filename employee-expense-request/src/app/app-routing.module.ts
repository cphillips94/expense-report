import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewHttpEmployeeComponent } from './manager/view-http-employee/view-http-employee.component';
import { LoginComponent } from './user/login/login.component';
import { LogoutComponent } from './user/logout/logout.component';
import { AuthGuard } from './user/auth.guard';
import { ViewTicketsComponent } from './manager/view-tickets/view-tickets.component';
import { EditTicketComponent } from './manager/edit-ticket/edit-ticket.component';
import { RequestComponent } from './employee/request/request.component';
import { ReviewTicketsComponent } from './employee/review-tickets/review-tickets.component';
import { EditInfoComponent } from './employee/edit-info/edit-info.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent }, 
  { path: "view-users", component: ViewHttpEmployeeComponent, canActivate: [AuthGuard] },
  { path: "view-tickets", component: ViewTicketsComponent, canActivate: [AuthGuard] },
  { path: "edit-ticket/ :myId", component: EditTicketComponent, canActivate: [AuthGuard] },
  { path: "view-employee-request", component: RequestComponent, canActivate: [AuthGuard] },
  {path: "review-tickets", component: ReviewTicketsComponent, canActivate: [AuthGuard]},
  {path: "edit-info/ :myId", component: EditInfoComponent, canActivate:[AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
