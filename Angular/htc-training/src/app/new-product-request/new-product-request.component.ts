import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators, AbstractControl, ValidationErrors } from '@angular/forms';
import { ProductRequestService } from '../product-request.service';
import { ProductMaster } from '../product-master';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-new-product-request',
  templateUrl: './new-product-request.component.html',
  styleUrls: ['./new-product-request.component.css']
})
export class NewProductRequestComponent {

  eventReactiveForm!: FormGroup;
  productMaster!: ProductMaster;
  typeList!: string[];
  categoryList!: string[];
  metricsList!: string[];
  title!: string;


  constructor(private formBuilder: FormBuilder, 
    private productService : ProductRequestService,
    private route: ActivatedRoute, 
    private router: Router) {
    this.eventReactiveForm = this.createReactiveForm();
    this.typeList = ["--choose--", "dance", "speech", "sing", "game"];
    this.categoryList = ["--choose--", "dance", "speech", "sing", "game"];
    this.metricsList = ["--choose--", "dance", "speech", "sing", "game"];
    this.title = "New Product Request";
  }

  createReactiveForm(): FormGroup {
    return this.formBuilder.group({
      productName: new FormControl('',Validators.required),
      category: new FormControl('', Validators.required),
      type: new FormControl('', Validators.required),
      length: new FormControl('', Validators.compose([Validators.maxLength(15)])),
      dia: new FormControl('', Validators.compose([Validators.maxLength(20)])),
      driveSize: new FormControl('', Validators.compose([Validators.maxLength(15)])),
      quantity: new FormControl('', Validators.compose([Validators.required,Validators.maxLength(15)])),
      volumeIn: new FormControl('', Validators.required),
      description: new FormControl('',)
    },{validator:validateForm});
  }

  reset() {
    this.eventReactiveForm.reset();
  }

  onSubmit() { 
   this.productMaster = this.eventReactiveForm.value;
    this.productService.saveProduct(this.productMaster);
    // .subscribe(this.gotoUserList());     
  }

  gotoUserList() {
    this.router.navigate(['/productList']);
  }

  saveProduct(productMaster : ProductMaster){
    this.productService.saveProduct(productMaster).subscribe((res:any) => { 
    }),console.error();
    
  }
}

//cross-field validation
function validateForm(control: FormGroup): ValidationErrors | null {

  if (control.value.eventNames == '--choose--') {
    return { "validEvent": true };
  }
  if (control.value.eventDate) {
    let currentDate = new Date().toISOString().substring(0,10);
    let checkDate = control.value.eventDate;
    if (checkDate < currentDate) {
      return { "validateDate": true }
    }
  }

  return null;
}


