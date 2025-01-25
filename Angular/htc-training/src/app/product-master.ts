export class ProductMaster {
    productId!:number;
    productName!:string;
    category!:string;
    type!:string;
    length!:number;
    dia!:number;
    driveSize!:number;
    quantity!:number;
    volumeIn!:number;
    description!:string;

    constructor(
        productId:number,
        productName:string,
        category:string,
        type:string,
        length:number,
        dia:number,
        driveSize:number,
        description:string){
            this.productId = productId;
            this.productName = productName;
            this.category = category;
            this.type = type;
            this.length = length;
            this.dia = dia;
            this.driveSize = driveSize;
            this.description = description;
    }
}
