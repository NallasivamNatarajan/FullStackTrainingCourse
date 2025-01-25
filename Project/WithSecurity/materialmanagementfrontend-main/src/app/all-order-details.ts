export class AllOrderDetails {
  orderId!: number;
  cartId!: number;
  orderNumber!: number;
  lineNumber!: number;
  userId!: number;
  requestedDepartment!: string;
  orderType!: string;
  orderRequestedDate!: Date;
  orderStatusId!: number;
  orderStatus!:string;
  requestSection!: string;
  createdBy!: string;
  createdDate!: Date;
  lastUpdatedBy!: string;
  lastUpdatedDate!: Date;

  constructor(orderId:number,cartId:number,orderNumber:number,lineNumber:number,userId:number,requestedDepartment:string,
    orderType:string,orderRequestedDate:Date,orderStatusId:number, requestSection:string,createdBy:string,createdDate:Date,
    lastUpdatedBy:string,lastUpdatedDate:Date,orderStatus:string){
    this.orderId = orderId;
    this.cartId =cartId;
    this.orderNumber=orderNumber;
    this.lineNumber=lineNumber;
    this.userId=userId;
    this.requestedDepartment=requestedDepartment;
    this.orderType=orderType;
    this.orderRequestedDate=orderRequestedDate;
    this.orderStatusId=orderStatusId;
    this.requestSection=requestSection;
    this.createdBy=createdBy;
    this.createdDate=createdDate;
    this.lastUpdatedBy=lastUpdatedBy;
    this.lastUpdatedDate=lastUpdatedDate;
    this.orderStatus=orderStatus;
 }
}
