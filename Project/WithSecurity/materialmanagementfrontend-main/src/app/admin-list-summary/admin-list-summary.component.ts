import { Component, OnInit } from '@angular/core';
import { IProduct } from '../iproduct';
import { OrderSummary } from '../order-summary';
import { OrderserviceService } from '../orderservice.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-list-summary',
  templateUrl: './admin-list-summary.component.html',
  styleUrls: ['./admin-list-summary.component.css']
})
export class AdminListSummaryComponent implements OnInit {
  orderData!:IProduct[];
  orderId!: number;
  orderSummary!: OrderSummary;
  orderNum !: string;
  comment!:string;
  shiftInchargeComment!: string;

  constructor(private orderService:OrderserviceService,private route: ActivatedRoute,private router: Router) { 
     }

  ngOnInit(): void {
    this.orderId = this.route.snapshot.params['orderId'];

    this.orderService.getToDoOrder(this.orderId)
    .subscribe((data:any) => {
      this.orderSummary = data;
      this.orderData= this.orderSummary.cartData;
      this.shiftInchargeComment=this.orderSummary.shiftInchargeComments;
    });
  }
  rejectOrderDetails(orderId: number){
      Swal.fire({
        title: 'Confirm Rejecting the Order ?', showDenyButton: true, showCancelButton: false, confirmButtonText: 'Reject', denyButtonText: `Cancel`,
      }).then((result) => {
        if (result.isConfirmed) {
          this.orderService.rejectOrderDetails(orderId,4,this.comment).subscribe((data:any) => {
       
            console.log(data); 
          }, error => console.log(error));
          Swal.fire('Order has been Rejected!', '', 'success').then(() => {
                window.location.reload();
              });
          this.router.navigate(['/home/admin-list']);
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
          this.orderService.approveOrderDetails(orderId,5,this.comment).subscribe((data:any) => {
            console.log(data);
             this.ngOnInit();
               },
           error => console.log(error));
          Swal.fire('Approved!', '', 'success').then(() => {
                window.location.reload();
              });
          // this.reloadCurrentRoute();
           this.router.navigate(['/home/admin-list']);
        } else if (result.isDenied) {
          Swal.fire('Not Approved', '', 'info')
        }
      })  
    }

    reloadCurrentRoute() {

      let currentUrl = this.router.url;
  
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
  
          this.router.navigate(['/home/admin-list']);
  
      });
  
  }


}
