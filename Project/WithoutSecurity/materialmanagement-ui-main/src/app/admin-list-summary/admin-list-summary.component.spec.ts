import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListSummaryComponent } from './admin-list-summary.component';

describe('AdminListSummaryComponent', () => {
  let component: AdminListSummaryComponent;
  let fixture: ComponentFixture<AdminListSummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListSummaryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminListSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
