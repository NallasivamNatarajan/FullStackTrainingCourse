import { Category } from '../category';
import { Type } from '../type';
import { Volume } from '../volume';

export class ProductMaster {
    productId!:number;
    productName!:string;
    category!:Category;
    type!:Type;
    length!:number;
    diameter!:number;
    lineNumner!:string;
    driveSize!:number;
    quantity!:number;
    volume!:Volume;
    description!:string;
    imageUrl!:string;
    createdBy!:string;

    constructor(
        productId:number,
        productName:string,
        category:Category,
        type:Type,
        length:number,
        diameter:number,
        driveSize:number,
        volume:Volume,
        description:string,
        createdBy:string){
            this.productId = productId;
            this.productName = productName;
            this.category = category;
            this.type = type;
            this.length = length;
            this.diameter = diameter;
            this.driveSize = driveSize;
            this.volume = volume;
            this.description = description;
            this.createdBy = createdBy;
    }
}
