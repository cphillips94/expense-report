import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './user/login/login.component';
import { LogoutComponent } from './user/logout/logout.component';
import { RequestComponent } from './employee/request/request.component';
import { ViewTicketsComponent } from './manager/view-tickets/view-tickets.component';
import { ReviewTicketsComponent } from './employee/review-tickets/review-tickets.component';
import { ViewHttpEmployeeComponent } from './manager/view-http-employee/view-http-employee.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EditTicketComponent } from './manager/edit-ticket/edit-ticket.component';
import { EditInfoComponent } from './employee/edit-info/edit-info.component';
import { UserInfoComponent } from './employee/user-info/user-info.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent,
    RequestComponent,
    ViewTicketsComponent,
    ReviewTicketsComponent,
    ViewHttpEmployeeComponent,
    EditTicketComponent,
    EditInfoComponent,
    UserInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
