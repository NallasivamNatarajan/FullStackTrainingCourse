import { TestBed } from '@angular/core/testing';

import { ParticipantJsonService } from './participant-json.service';

describe('ParticipantJsonService', () => {
  let service: ParticipantJsonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParticipantJsonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
