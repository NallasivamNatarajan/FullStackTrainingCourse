import { IProduct } from './iproduct';

export class OrderSummary {
    orderId: number;
    cartId: number;
    orderNumber: string;
    lineNumber: string;
    orderType: string;
    orderStatus:string;
    orderRequestedDate: Date;
    requestSection: string;
    adminComments:string;
    shiftInchargeComments:string;
    userId:number;
    userName: string;
    departmentName: string;
    cartData: IProduct[];
   
    constructor(orderId:number,cartId:number,orderNumber:string,lineNumber:string,orderType:string,orderStatus:string,orderRequestedDate:Date,
        requestSection:string,userId:number,userName:string,departmentName:string,cartData:IProduct[],adminComments:string,shiftInchargeComments:string){
        this.orderId = orderId;
        this.cartId =cartId;
        this.orderNumber=orderNumber;
        this.lineNumber=lineNumber;
        this.orderType=orderType;
        this.shiftInchargeComments=shiftInchargeComments;
        this.adminComments=adminComments;
        this.orderStatus=orderStatus;
        this.orderRequestedDate=orderRequestedDate;
        this.requestSection=requestSection;
        this.userId=userId;
        this.userName=userName;
        this.departmentName=departmentName;
        this.cartData=cartData
    }
}
