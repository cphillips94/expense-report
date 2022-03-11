import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketHttpService } from 'src/app/ticket-http.service';
import { ticket } from 'src/app/ticket.model';

@Component({
  selector: 'app-view-tickets',
  templateUrl: './view-tickets.component.html',
  styleUrls: ['./view-tickets.component.css']
})
export class ViewTicketsComponent implements OnInit {
  allTickets: ticket[] = [];
  toggleAdd: boolean = false;

  newRequest: ticket = {
    requestId:0,
    employeeId:0,
    requestAmount:0,
    requestDesc:"",
    status:""
  }


  constructor(private ticketHttpService: TicketHttpService, private router: Router) { }

  ngOnInit(): void {
    this.loadAllTickets();
  }

  loadAllTickets(){
    this.ticketHttpService.fetchAllTickets().subscribe((response)=>{
      console.log(response);
      this.allTickets= response;
    });
  }
  toggleAddForm(){
    if(this.toggleAdd){
      this.toggleAdd = false;
  }else{
    this.toggleAdd = true;
  }
  }


  goToEditTicket(requestId: Number){
    this.router.navigate(['view-users', requestId]);
  }



  addTicket(){
    this.ticketHttpService.addTicket(this.newRequest).subscribe((response)=>{
      console.log(response);
      this.newRequest={
        requestId:0,
        employeeId:0,
        requestAmount:0,
        requestDesc:"",
        status:""
      }
      this.loadAllTickets();
    })
  }
  }
