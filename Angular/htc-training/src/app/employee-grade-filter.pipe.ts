import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from './employee';

@Pipe({
  name: 'employeeGradeFilter'
})
export class EmployeeGradeFilterPipe implements PipeTransform {

  transform(employees: Employee[], minGrade: number, maxGrade: number): Employee[] {
    let filteredEmployee = employees.filter(employee => {
      if (minGrade != null && maxGrade != null) {
        return employee.grading >= minGrade && employee.grading <= maxGrade;
      } else if (maxGrade == null && minGrade != null) {
        return employee.grading >= minGrade;
      } else if (maxGrade != null && minGrade == null) {
        return employee.grading <= maxGrade;
      } else {
        return employee;
      }
    })
    return filteredEmployee;
  }

}
