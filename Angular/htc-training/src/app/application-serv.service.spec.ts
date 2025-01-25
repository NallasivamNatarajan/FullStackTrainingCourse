import { TestBed } from '@angular/core/testing';

import { ApplicationServService } from './application-serv.service';

describe('ApplicationServService', () => {
  let service: ApplicationServService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApplicationServService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
