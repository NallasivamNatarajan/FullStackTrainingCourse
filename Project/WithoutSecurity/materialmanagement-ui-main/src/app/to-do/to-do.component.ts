import { Component, OnInit } from '@angular/core';
import { IProduct } from '../iproduct';
import { OrderSummary } from '../order-summary';
import { OrderserviceService } from '../orderservice.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ToDoListComponent } from '../to-do-list/to-do-list.component';

@Component({
  selector: 'app-to-do',
  templateUrl: './to-do.component.html',
  styleUrls: ['./to-do.component.css']
})

export class ToDoComponent implements OnInit {
  orderData!:IProduct[];
  orderId!: number;
  orderSummary!: OrderSummary;
  orderNum !: string;
  comment!:string;

  constructor(private orderService:OrderserviceService,private route: ActivatedRoute,private router: Router) { 
     }

  ngOnInit(): void {
    this.orderId = this.route.snapshot.params['orderId'];

    this.orderService.getOrder(this.orderId)
    .subscribe((data:any) => {
      this.orderSummary = data;
      this.orderData= this.orderSummary.cartData;
    });
  }
  rejectOrderDetails(orderId: number){
      Swal.fire({
        title: 'Confirm Rejecting the Order ?', showDenyButton: true, showCancelButton: false, confirmButtonText: 'Reject', denyButtonText: `Cancel`,
      }).then((result) => {
        if (result.isConfirmed) {
          this.orderService.rejectOrderDetails(orderId,3,this.comment).subscribe((data:any) => {
       
            console.log(data); 
          }, error => console.log(error));
          Swal.fire('Order has been Rejected!', '', 'success').then(() => {
                window.location.reload();
              });
          this.router.navigate(['/home/to-do']);
        } else if (result.isDenied) {
          Swal.fire('Cancelled order Rejection', '', 'info')
        }
      })
    }

    approveOrderDetails(orderId: number){
      Swal.fire({
        title: 'Confirm Approval ?', showDenyButton: true, showCancelButton: false, confirmButtonText: 'Approve', denyButtonText: `Cancel`,
      }).then((result) => {
        if (result.isConfirmed) {
          this.orderService.approveOrderDetails(orderId,2,this.comment).subscribe((data:any) => {
            console.log(data);
             this.ngOnInit();
               },
           error => console.log(error));
          Swal.fire('Approved!', '', 'success').then(() => {
                window.location.reload();
              });
          // this.reloadCurrentRoute();
           this.router.navigate(['/home/to-do']);
        } else if (result.isDenied) {
          Swal.fire('Not Approved', '', 'info')
        }
      })  
    }

    reloadCurrentRoute() {

      let currentUrl = this.router.url;
  
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
  
          this.router.navigate(['/home/to-do']);
  
      });
  
  }


}
