import { TestBed } from '@angular/core/testing';

import { BotserviceService } from './botservice.service';

describe('BotserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BotserviceService = TestBed.get(BotserviceService);
    expect(service).toBeTruthy();
  });
});
