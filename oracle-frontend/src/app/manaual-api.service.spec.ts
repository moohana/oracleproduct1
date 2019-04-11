import { TestBed } from '@angular/core/testing';

import { ManaualApiService } from './manaual-api.service';

describe('ManaualApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ManaualApiService = TestBed.get(ManaualApiService);
    expect(service).toBeTruthy();
  });
});
