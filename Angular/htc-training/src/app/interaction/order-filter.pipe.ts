import { Pipe, PipeTransform } from '@angular/core';
import { Order } from './order';

@Pipe({
    name : 'orderfilter'
})
export class OrderFilter implements PipeTransform{

    transform(customerOrders : Order[] , salesRepId:string): Order[]{
        
        if(!salesRepId)
            return customerOrders;

        return customerOrders.filter(customerOrders => customerOrders.salesRepId == salesRepId);
    }
}