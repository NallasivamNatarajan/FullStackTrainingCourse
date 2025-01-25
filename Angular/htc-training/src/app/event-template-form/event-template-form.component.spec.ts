import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventTemplateFormComponent } from './event-template-form.component';

describe('EventTemplateFormComponent', () => {
  let component: EventTemplateFormComponent;
  let fixture: ComponentFixture<EventTemplateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventTemplateFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EventTemplateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
