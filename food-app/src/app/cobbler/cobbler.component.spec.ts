import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CobblerComponent } from './cobbler.component';

describe('CobblerComponent', () => {
  let component: CobblerComponent;
  let fixture: ComponentFixture<CobblerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CobblerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CobblerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
