import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllUsersProfileComponent } from './all-users-profile.component';

describe('AllUsersProfileComponent', () => {
  let component: AllUsersProfileComponent;
  let fixture: ComponentFixture<AllUsersProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllUsersProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllUsersProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
