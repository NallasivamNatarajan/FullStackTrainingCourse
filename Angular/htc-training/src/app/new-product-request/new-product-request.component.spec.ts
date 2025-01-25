import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewProductRequestComponent } from './new-product-request.component';

describe('NewProductRequestComponent', () => {
  let component: NewProductRequestComponent;
  let fixture: ComponentFixture<NewProductRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewProductRequestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewProductRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
