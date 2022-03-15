import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketHttpService } from 'src/app/ticket-http.service';
import { ticket } from 'src/app/ticket.model';

@Component({
  selector: 'app-review-tickets',
  templateUrl: './review-tickets.component.html',
  styleUrls: ['./review-tickets.component.css']
})
export class ReviewTicketsComponent implements OnInit {
  allTickets: ticket[] = [];
  toggleAdd: boolean = false;

  newRequest: ticket = {
    requestId:0,
    employeeId:0,
    requestAmount:0,
    requestDesc:"",
    status:"Pending"
  }


  constructor(private ticketHttpService: TicketHttpService, private router: Router) { }

  ngOnInit(): void {
    this.loadAllTicketsById();
  }

  loadAllTicketsById(){
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
      
      this.newRequest={
        requestId:0,
        employeeId:0,
        requestAmount:0,
        requestDesc:"",
        status:""
      }
      this.loadAllTicketsById();
    })
  }
  }
