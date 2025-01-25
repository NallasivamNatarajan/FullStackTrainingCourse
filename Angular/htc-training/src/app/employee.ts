export class Employee {
    employeeId!: string;
    employeeName!: string;
    salary!: number;
    joinDate?: Date;
    department!: string;
    designation!: string;
    grading!: number;

    constructor(employeeId: string, employeeName: string,
        salary: number, joinDate: Date,
        department: string, designation: string, grading: number) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.joinDate = joinDate;
        this.department = department;
        this.designation = designation;
        this.grading = grading;
    }
}
