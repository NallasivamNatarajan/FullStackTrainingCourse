export class OrderDetails {
    orderCode!:number;
    requestBy!:string;
    requestDepartment!:string;
    requestSection!:string;
    orderType!:string;
    requestedOn!:Date;
    status!:string;
    
    constructor( orderCode:number,requestBy:string,requestDepartment:string,requestSection:string,orderType:string,
        requestedOn:Date,status:string)
    {
        this.orderCode=orderCode;
        this.requestBy=requestBy;
        this.requestDepartment=requestDepartment;
        this.requestSection=requestSection;
        this.orderType=orderType;
        this.requestedOn=requestedOn;
        this.status=status;
    }
}
