import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventReactiveFormComponent } from './event-reactive-form.component';

describe('EventReactiveFormComponent', () => {
  let component: EventReactiveFormComponent;
  let fixture: ComponentFixture<EventReactiveFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventReactiveFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EventReactiveFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
