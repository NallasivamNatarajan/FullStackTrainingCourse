import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-base',
  templateUrl: './base.component.html',
  styleUrls: ['./base.component.css']
})
export class BaseComponent{

  @Input()
  existingDataReceived!: string;

  @Output()
  newItemEvent = new EventEmitter<string>();

  constructor() { }
  
  addNewItem(value : string){
    this.newItemEvent.emit(value);
  }



}
