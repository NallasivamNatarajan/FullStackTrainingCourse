import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-existing',
  templateUrl: './existing.component.html',
  styleUrls: ['./existing.component.css']
})
export class ExistingComponent {

  existingInfo!: string;
  items!: string[];
  constructor() {
    this.existingInfo = "Reverse Process of Child Component to Parent Component";
    this.items = ['Arun', 'Bala'];
   }

  addNewItem(newItem : string){
    this.items.push(newItem);
  }

}
