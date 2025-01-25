import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators, ValidationErrors } from '@angular/forms';

import { ProductMaster } from '../product-master';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductRequestService } from '../../service/product-request.service';
import { Category } from '../../category';
import { Type } from '../../type';
import { Volume } from '../../volume';
import Swal from 'sweetalert2';
import { IDropDownValues } from '../../IDropDownValues';
import { LineNumber } from '../../line-number';


@Component({
  selector: 'app-new-product-request',
  templateUrl: './new-product-request.component.html',
  styleUrls: ['./new-product-request.component.css']
})
export class NewProductRequestComponent implements OnInit{

  newProductForm!: FormGroup;
  productMaster!: ProductMaster;
  typeList!: Type[];
  categoryList!: Category[];
  volumeList!: Volume[];
  lineNumberList!: string[];
  lineNumbersList!: LineNumber[];
  dropDownListData!: IDropDownValues;
  title!: string;
  imageUrl!: string;
  userdata:any={
    id:'',
    role: '',
    name:''
  }
  
  onSelectFile(event: any) {

    if (event.target.files) {
      var reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
      reader.onload = (event: any) => {
        this.imageUrl = event.target.result;
      }
    }
  }

  constructor(private formBuilder: FormBuilder,
    private productService: ProductRequestService,
    private route: ActivatedRoute,
    private router: Router) {
    this.newProductForm = this.createReactiveForm();
    this.title = "New Product Request";
  }

  ngOnInit(){
    this.productService.getDropDownValues().subscribe((data) => {
      this.dropDownListData = data;
      this.categoryList = this.dropDownListData.categoryList;
      this.typeList = this.dropDownListData.typeList;
      this.volumeList = this.dropDownListData.volumeList;
      this.lineNumbersList = this.dropDownListData.lineNumberList; 
    }, error => console.log(error));
    this.userdata = JSON.parse(localStorage.getItem('userData') || '{}');
  }
  createReactiveForm(): FormGroup {
    return this.formBuilder.group({
      imageUrl: new FormControl(''),
      productName: new FormControl('', Validators.required),
      category: new FormControl('', Validators.required),
      type: new FormControl('', Validators.required),
      length: new FormControl(''),
      diameter: new FormControl(''),
      driveSize: new FormControl(''),
      lineNumber: new FormControl('', Validators.required),
      quantity: new FormControl('', Validators.required),
      volume: new FormControl('', Validators.required),
      description: new FormControl('', Validators.compose([Validators.maxLength(254)]))
    }, { validator: validateForm });
  }

  reset() {
    this.newProductForm.reset();
  }

  onSubmit() {
    
     
      Swal.fire({
        title: 'Confirm Registering New Prdocut ?', showDenyButton: true, showCancelButton: true, confirmButtonText: 'Save', denyButtonText: `Don't save`,
      }).then((result) => {
        if (result.isConfirmed) {
          this.productMaster = this.newProductForm.value;
          this.productMaster.createdBy = this.userdata.name;
            this.productService.saveProduct(this.productMaster).subscribe((data : any) => {
              Swal.fire('Saved!', '', 'success');
              console.log(data);
              this.router.navigate(['/home/view-products']);
          }, error => {
            console.log(error);
            Swal.fire("Product Already Exist", '', 'error')
          }) 
         
        } else if (result.isDenied) {
          Swal.fire('Changes are not saved', '', 'info')
        }
      })
  }

  gotoUserList() {
    this.router.navigate(['/productList']);
  }

  saveProduct(productMaster: ProductMaster) {
    this.productService.saveProduct(productMaster).subscribe((res: any) => {
    }), console.error();

  }
}

//cross-field validation
function validateForm(control: FormGroup): ValidationErrors | null {
  if (control.value.quantity == '' && control.value.quantity == 0) {
      return { "validateQuantityCount": true };
    }
  return null;

}


