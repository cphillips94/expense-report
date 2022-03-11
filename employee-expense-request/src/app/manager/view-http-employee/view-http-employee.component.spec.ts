import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewHttpEmployeeComponent } from './view-http-employee.component';

describe('ViewHttpEmployeeComponent', () => {
  let component: ViewHttpEmployeeComponent;
  let fixture: ComponentFixture<ViewHttpEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewHttpEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewHttpEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
