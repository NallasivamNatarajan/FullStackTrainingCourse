import { Pipe, PipeTransform } from '@angular/core';
import { IProduct } from './iproduct';
import { Category } from './category';

@Pipe({
  name: 'placeOrder'
})
export class PlaceOrderPipe implements PipeTransform {

  transform(products: IProduct[], lineNumber: string, productNameSearch: string, categorySearch:string): IProduct[] {

    let filteredProduct = products.filter(product => {
      if (lineNumber != "" && (productNameSearch &&  productNameSearch != "" )&& categorySearch !="") {
        return product.lineNumber == lineNumber && 
        (product.productName.toLowerCase().includes(productNameSearch.toLowerCase()) ||
          product.partNumber.toLowerCase().includes(productNameSearch.toLowerCase()) ||
          product.category.categoryName.toLowerCase().includes(productNameSearch.toLowerCase()) ||
          product.type.typeName.toLowerCase().includes(productNameSearch.toLowerCase())
      )&& product.category.categoryName==categorySearch;
      } else if ((lineNumber != "" && categorySearch !="") || productNameSearch == "" ) {
        return product.lineNumber == lineNumber && product.category.categoryName==categorySearch;
      }
       return product;
    })
    return filteredProduct;
  }
}
