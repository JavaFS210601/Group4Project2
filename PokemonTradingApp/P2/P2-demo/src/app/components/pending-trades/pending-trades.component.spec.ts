import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingTradesComponent } from './pending-trades.component';

describe('PendingTradesComponent', () => {
  let component: PendingTradesComponent;
  let fixture: ComponentFixture<PendingTradesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PendingTradesComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingTradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
