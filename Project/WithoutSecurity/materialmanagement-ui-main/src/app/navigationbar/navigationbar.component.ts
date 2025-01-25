import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navigationbar',
  templateUrl: './navigationbar.component.html',
  styleUrls: ['./navigationbar.component.css']
})
export class NavigationbarComponent implements OnInit {

  username:string='';

  userdata:any={
    name:'',
role: ''
  }

  isCart:boolean=false;

  constructor() {}

  ngOnInit(): void {
    this.userdata = JSON.parse(localStorage.getItem('userData') || '{}');
    this.username=this.userdata.name;

    const cartdata =JSON.parse(localStorage.getItem('cartProducts') || '{}');
    if(cartdata.length>0){
      this.isCart=true;
    }else{
      this.isCart=false;
    }
  }

  isShift(){
    return this.userdata.role == 'shiftincharge';
  }

  isAdmin(){
    return this.userdata.role == 'admin';
  }

  isSupervisor(){
    return this.userdata.role == 'supervisor';
  }


}
