import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyOpenTradesComponent } from './my-open-trades.component';

describe('MyOpenTradesComponent', () => {
  let component: MyOpenTradesComponent;
  let fixture: ComponentFixture<MyOpenTradesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MyOpenTradesComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyOpenTradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
