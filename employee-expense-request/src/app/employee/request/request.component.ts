import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketHttpService } from 'src/app/ticket-http.service';
import { ticket } from 'src/app/ticket.model';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
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
  
    
 // let requestId: any = this.activatedRoute.snapshot.paramMap.get("myId");
   // console.log(bookId);
  
  // this.bookHttpService.fetchABook(bookId).subscribe((response)=>{
    //this.newBook = response;
  // });

 // }

  //test(myTitle: any){
   // console.log(myTitle);
 // }
  
 //updateBook(){
    //this.bookHttpService.updateBook(this.newBook).subscribe((response)=>{
      //console.log(response);
  
     // this.router.navigate(['book-http-crud']);
    //});
  }
}
