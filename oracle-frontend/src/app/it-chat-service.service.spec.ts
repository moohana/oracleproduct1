import { TestBed } from '@angular/core/testing';

import { ItChatServiceService } from './it-chat-service.service';

describe('ItChatServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ItChatServiceService = TestBed.get(ItChatServiceService);
    expect(service).toBeTruthy();
  });
});
