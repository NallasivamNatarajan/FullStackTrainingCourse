import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeGradeFilterPipe } from '../employee-grade-filter.pipe';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent{

  employeeList!:Employee[];
  employeeGradeFilter!: EmployeeGradeFilterPipe;
  minGrade!:number;
  maxGrade!:number;

  constructor(){

    this.employeeList = [

      new Employee('E001','Siva',30300,new Date("Fri Dec 08 2019 07:44:57"),'Training','Trainer',5.00),

      new Employee('E002','Sateesh',40000,new Date("Fri Dec 08 2019 07:44:57"),'Training','Trainer',4.00),

      new Employee('E003','Hari',30500,new Date("Fri Dec 08 2019 07:44:57"),'Testing','Tester',5.00),

      new Employee('E004','Sivam',63000,new Date("Fri Dec 08 2019 07:44:57"),'Testing','Tester',3.00),

      new Employee('E005','Roopendar',43000,new Date("Fri Dec 08 2019 07:44:57"),'Testing','Tester',4.5),

      new Employee('E006','Niveditha',36000,new Date("Fri Dec 08 2019 07:44:57"),'Training','Trainer',5.00),

      new Employee('E007','Mani',73000,new Date("Fri Dec 08 2019 07:44:57"),'Projects','Programmer',3.00),

      new Employee('E008','Murugaiyan',43000,new Date("Fri Dec 08 2019 07:44:57"),'Projects','Programmer',4.00)

    ];

  }


}
