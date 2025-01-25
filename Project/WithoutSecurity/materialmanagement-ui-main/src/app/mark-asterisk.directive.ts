import { Directive, OnInit, Input, ElementRef } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Directive({
  selector: '[appMarkAsterisk]'
})
export class MarkAsteriskDirective implements OnInit{

  @Input() formGroup!: FormGroup;
  @Input() controlName!: string;

  constructor(private elementRef: ElementRef) {
  }
  ngOnInit(): void {
      this.elementRef.nativeElement.innerHTML = '*';
  }

}
