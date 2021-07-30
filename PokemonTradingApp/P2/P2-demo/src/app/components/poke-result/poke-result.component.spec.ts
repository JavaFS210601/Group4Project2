import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeResultComponent } from './poke-result.component';

describe('PokeResultComponent', () => {
  let component: PokeResultComponent;
  let fixture: ComponentFixture<PokeResultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PokeResultComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PokeResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
