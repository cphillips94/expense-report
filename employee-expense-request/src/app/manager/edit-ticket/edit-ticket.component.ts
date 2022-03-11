import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TicketHttpService } from 'src/app/ticket-http.service';
import { ticket } from 'src/app/ticket.model';

@Component({
  selector: 'app-edit-ticket',
  templateUrl: './edit-ticket.component.html',
  styleUrls: ['./edit-ticket.component.css']
})
export class EditTicketComponent implements OnInit {
  newRequest: ticket = {
    requestId:0,
    employeeId:0,
    requestAmount:0,
    requestDesc:"",
    status:""
  }

  constructor(private activatedRoute: ActivatedRoute, 
              private ticketHttpService: TicketHttpService,
              private router: Router) { }

  ngOnInit(): void {
    // to take out the route parameter, we need to inject ActivatedRoute in the constructor
    let requestId: any = this.activatedRoute.snapshot.paramMap.get("myId");
    console.log(requestId);
    // fetch the book with the bookId from the service layer
   this.ticketHttpService.fetchATicket(requestId).subscribe((response)=>{
    this.newRequest = response;
   });

  }

  test(myTitle: any){
    console.log(myTitle);
  }
  
  updateTicket(){
    this.ticketHttpService.updateTicket(this.newRequest).subscribe((response)=>{
      console.log(response);
      // once update is over navigate back to ListHttpBookComponent
      this.router.navigate(['edit-request']);
    });
  }
}
