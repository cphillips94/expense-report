import { TestBed } from '@angular/core/testing';

import { ManagerLogGuard } from './manager-log.guard';

describe('ManagerLogGuard', () => {
  let guard: ManagerLogGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ManagerLogGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
