import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatBotHomepageComponent } from './chat-bot-homepage.component';

describe('ChatBotHomepageComponent', () => {
  let component: ChatBotHomepageComponent;
  let fixture: ComponentFixture<ChatBotHomepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChatBotHomepageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChatBotHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
