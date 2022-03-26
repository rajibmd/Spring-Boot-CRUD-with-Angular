import { TestBed } from '@angular/core/testing';

import { PatientserService } from './patientser.service';

describe('PatientserService', () => {
  let service: PatientserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PatientserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
