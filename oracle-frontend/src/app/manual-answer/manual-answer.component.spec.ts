import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManualAnswerComponent } from './manual-answer.component';

describe('ManualAnswerComponent', () => {
  let component: ManualAnswerComponent;
  let fixture: ComponentFixture<ManualAnswerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManualAnswerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManualAnswerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
