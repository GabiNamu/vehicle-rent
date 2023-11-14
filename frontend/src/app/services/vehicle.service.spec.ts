import { TestBed } from '@angular/core/testing';

import { VehicleServiceTsService } from './vehicle.service.ts.service';

describe('VehicleServiceTsService', () => {
  let service: VehicleServiceTsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehicleServiceTsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
