import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParticipantChildComponent } from './participant-child.component';

describe('ParticipantChildComponent', () => {
  let component: ParticipantChildComponent;
  let fixture: ComponentFixture<ParticipantChildComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParticipantChildComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParticipantChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
