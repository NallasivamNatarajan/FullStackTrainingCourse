import { EmployeeGradeFilterPipe } from './employee-grade-filter.pipe';

describe('EmployeeGradeFilterPipe', () => {
  it('create an instance', () => {
    const pipe = new EmployeeGradeFilterPipe();
    expect(pipe).toBeTruthy();
  });
});
