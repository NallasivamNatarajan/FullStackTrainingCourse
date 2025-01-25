export class Order {
    orderId:string;
    orderDate:Date;
    salesRepId:string;

    constructor(orderId:string,orderDate:Date,salesRepId:string){
        this.orderId=orderId;
        this.orderDate=orderDate;
        this.salesRepId=salesRepId;
    }
}
