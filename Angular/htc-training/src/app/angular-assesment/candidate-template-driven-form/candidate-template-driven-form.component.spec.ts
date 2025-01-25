import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateTemplateDrivenFormComponent } from './candidate-template-driven-form.component';

describe('CandidateTemplateDrivenFormComponent', () => {
  let component: CandidateTemplateDrivenFormComponent;
  let fixture: ComponentFixture<CandidateTemplateDrivenFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CandidateTemplateDrivenFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidateTemplateDrivenFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
