import { Component, OnInit } from '@angular/core';
import { Candidate } from '../candidate';

@Component({
  selector: 'app-candidate-template-driven-form',
  templateUrl: './candidate-template-driven-form.component.html',
  styleUrls: ['./candidate-template-driven-form.component.css']
})
export class CandidateTemplateDrivenFormComponent {

  candidate !: Candidate; 
  jobs !: string[];
  title !: string;
  constructor() {
    this.candidate = new Candidate();
    this.title = "Job Registration Form";
    this.jobs = ['--choose--', 'Developer', 'Tester', 'Trainer'];
   }

   clearForm(){
     window.history.back();
   }



}
