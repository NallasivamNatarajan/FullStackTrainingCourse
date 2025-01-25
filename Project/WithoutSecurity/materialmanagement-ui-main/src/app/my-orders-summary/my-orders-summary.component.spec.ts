import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyOrdersSummaryComponent } from './my-orders-summary.component';

describe('MyOrdersSummaryComponent', () => {
  let component: MyOrdersSummaryComponent;
  let fixture: ComponentFixture<MyOrdersSummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyOrdersSummaryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyOrdersSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
